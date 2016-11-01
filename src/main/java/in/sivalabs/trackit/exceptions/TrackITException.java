/**
 * 
 */
package in.sivalabs.trackit.exceptions;

/**
 * @author Siva
 *
 */
public class TrackITException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public TrackITException(String msg, Throwable t)
	{
		super(msg, t);
	}

	public TrackITException(String msg)
	{
		super(msg);
	}

	public TrackITException(Throwable t)
	{
		super(t);
	}

}
