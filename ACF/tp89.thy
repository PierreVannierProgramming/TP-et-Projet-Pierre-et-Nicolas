theory tp89
imports Main List (* "~~/src/HOL/Library/Efficient_Nat"  *)
begin

type_synonym transid= "nat*nat*nat"

datatype message= 
  Pay transid nat  
| Ack transid nat
| Cancel transid

type_synonym transaction= "transid * nat"

datatype anyNat=
  ANY
| N nat

type_synonym trans= "(transid * anyNat * anyNat * bool)"

type_synonym transBdd= "trans list"

fun transValid:: "anyNat \<Rightarrow> anyNat \<Rightarrow> bool"
where
"transValid ANY ANY = False"|
"transValid ANY a = False"|
"transValid a ANY = False"|
"transValid (N c) (N m) = (if (c\<ge>m)\<and>(m>0)\<and>(c>0) then True else False)"

fun memTransid:: "transid \<Rightarrow> transid \<Rightarrow> bool"
where
"memTransid t1 t2 = (if t1=t2 then True else False)"

fun modifPay:: "transid \<Rightarrow> anyNat \<Rightarrow> anyNat \<Rightarrow> anyNat \<Rightarrow> trans"
where
"modifPay t ANY ANY ma = (t,ANY,ma,False)"|
"modifPay t ANY a ma = (t,a,ma,False)"|
"modifPay t a ANY ma = (t,a,ma,False)"|
"modifPay t (N cl1) (N cl2) ANY = (if cl1>cl2 then (t,(N cl1),ANY,False) else (t,(N cl2),ANY,False))"|
"modifPay t (N cl1) (N cl2) ma = (if (transValid (N cl2) ma) then (t,(N cl2),ma,False) else (if cl1>cl2 
  then (t,(N cl1),ma,False) else (t,(N cl2),ma,False)))"

fun modifAck:: "transid \<Rightarrow> anyNat \<Rightarrow> anyNat \<Rightarrow> anyNat \<Rightarrow> trans"
where
"modifAck t ANY cl ANY = (t,cl,ANY,False)"|
"modifAck t ANY cl ma = (t,cl,ma,False)"|
"modifAck t ma cl ANY = (t,cl,ma,False)"|
"modifAck t (N ma1) ANY (N ma2) = (if ma1<ma2 then (t,ANY,(N ma1),False) else (t,ANY,(N ma2),False))"|
"modifAck t (N ma1) cl (N ma2) = (if (transValid cl (N ma2)) then (t,cl,(N ma2),False) else (if ma1<ma2 
  then (t,cl,(N ma1),False) else (t,cl,(N ma2),False)))"

fun traiterMessage:: "message \<Rightarrow> transBdd \<Rightarrow> transBdd"
where
"traiterMessage (Pay t n) [] = [(t,(N n),ANY, False)]"|
"traiterMessage (Pay t1 c2) ((t2,cl,ma,can)#ls) = (if (memTransid t1 t2) 
  then (if (~can) then (modifPay t1 (N c2) cl ma)#ls else (t2,cl,ma,can)#ls) 
  else (t2,cl,ma,can)#(traiterMessage (Pay t1 c2) ls))"|
"traiterMessage (Ack t n) [] = [(t,ANY,(N n),False)]"|
"traiterMessage (Ack t1 m2) ((t2,cl,ma,can)#ls) = (if (memTransid t1 t2) 
  then (if (~can) then (modifAck t1 (N m2) cl ma)#ls else (t2,cl,ma,can)#ls) 
  else (t2,cl,ma,can)#(traiterMessage (Ack t1 m2) ls))"|
"traiterMessage (Cancel t1) [] = [(t1,ANY,ANY,True)]"|
"traiterMessage (Cancel t1) ((t2,cl,ma,can)#ls) = (if t1=t2 
  then (t1,cl,ma,True)#ls else (t2,cl,ma,can)#(traiterMessage (Cancel t1) ls))"

fun export:: "transBdd \<Rightarrow> transaction list"
where
"export [] = []"|
"export ((t,ANY,ma,can)#ls) = (export ls)"|

"export ((t,(N cl),ma,can)#ls) = (if ((~can)\<and>(transValid (N cl) ma)) then (t,cl)#(export ls) else (export ls))"

fun traiterMessageList:: "message list \<Rightarrow> transBdd"
where
"traiterMessageList [] = []"|
"traiterMessageList (m#ls) = (traiterMessage m (traiterMessageList ls))"


lemma lem1: "(List.member (export ls) (t,am)) \<longrightarrow> am > 0"
(*quickcheck[tester = narrowing, size=7,timeout=300]*)
sorry

lemma lem2: "((export (traiterMessageList lm)) = (l1@[(t,m)]@l2)) \<longrightarrow> (~(List.member (l1@l2) (t,n)))"
(*quickcheck[tester = narrowing, size=7,timeout=300]*)
sorry

lemma lem3: "((export (traiterMessageList (l1@[(Cancel t)]@l2)))=l) \<longrightarrow> (~(List.member l (t,n)))"
(*quickcheck[tester = narrowing, size=5,timeout=300]*)
sorry

(*lemma lem4: "((export (traiterMessageList (l1@[(Pay t x)]@l2@[(Cancel t)]@l3@[(Pay t y)]@l4
)))=l) \<longrightarrow> (~(List.member l (t,n)))"*)

lemma lem5: "((List.member lm (Pay tr amc)) \<and>
  (List.member lm (Ack tr amm)) \<and>
    (~(List.member lm (Cancel tr))) \<and>
      (amc\<ge>amm) \<and> (amc>0) \<and> (amm>0)\<and>
        (export (traiterMessageList lm))=l) \<longrightarrow> (List.member l (tr,am))"
quickcheck[ size=5,timeout=300]
sorry

lemma lem6: "((export (traiterMessageList lm))=l \<and> (List.member l (tr,am))\<and> (amc\<ge>amm))
  \<longrightarrow> ((List.member lm (Pay tr amc)) \<and> (List.member lm (Ack tr amm)) )"
quickcheck[ size=5,timeout=300]
sorry

lemma lem7client: "((am2>am1) \<and> (traiterMessageList (l1@[(Pay tr am1)]@l2@[(Pay tr am2)]@l3))=l) \<longrightarrow>
  (~(List.member l (tr,(N am1),ma,can)))"
(*quickcheck[ size=5,timeout=300]*)
sorry

lemma lem7marchant: "((am2<am1) \<and> (traiterMessageList (l1@[(Ack tr am1)]@l2@[(Ack tr am2)]@l3))=l) \<longrightarrow>
  (~(List.member l (tr,cl,(N am1),can)))"
(*quickcheck[ size=5,timeout=300]*)
sorry

lemma lem8: "((cl\<ge>ma) \<and> (cl>0) \<and> (ma>0) \<and> (cl\<noteq>am) \<and> (export l)=li \<and> (traiterMessageList lm)=l \<and> (List.member l (tr,(N cl),(N ma),False)) \<and>
  (~(List.member lm (Cancel tr)))) \<longrightarrow> ((~(List.member li (tr,am))) )"
quickcheck[ size=5,timeout=300]
sorry

lemma lem9: "(List.member (export (traiterMessageList lm)) (tr,am)) \<longrightarrow> (List.member lm (Pay tr am))"
(*quickcheck[ size=5,timeout=300]*)
sorry

end
