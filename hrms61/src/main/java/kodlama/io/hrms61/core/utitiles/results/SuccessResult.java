package kodlama.io.hrms61.core.utitiles.results;

public class SuccessResult extends Result {
	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String message) {
		super(true,message);
	}
}
