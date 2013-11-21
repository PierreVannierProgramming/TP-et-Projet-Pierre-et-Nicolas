package command;

import receiver.Engine;

public abstract class AbstractCommand implements command {
	protected Engine e;
	@Override
	public abstract void executer();
}
