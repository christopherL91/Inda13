/**
* own exception class.
*/

/**
* @author Christopher Lillthors
* @version 2.0
*/
public class NoRootException extends IllegalArgumentException{
	public NoRootException(){
		super("Root is not set");
	}
}
