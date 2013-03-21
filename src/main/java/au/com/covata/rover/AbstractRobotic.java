package au.com.covata.rover;

import java.io.Serializable;

public abstract class AbstractRobotic implements Serializable{


	private static final long serialVersionUID = 1305308698206091785L;

	public boolean validateInstruction(String instruction) {
		boolean result = true;
		if(null == instruction || instruction.length() == 0) {
			result = false;
		}
		return result;
	}

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(final Object other);

}
