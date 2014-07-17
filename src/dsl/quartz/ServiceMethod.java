package dsl.quartz;

public interface ServiceMethod {

	public Quartz execute(Quartz quartz, int... values);

}
