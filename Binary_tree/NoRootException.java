public class NoRootException extends IllegalArgumentException{
	public NoRootException(){
		super("Root is not set");
	}
}
