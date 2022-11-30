package p1;

public class Demo {

	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		Turkey turkey = new WildTurkey();
		duck.quack();
		duck.fly();
		turkey.gobble();
		turkey.fly();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		turkeyAdapter.quack();
		turkeyAdapter.fly();
		Turkey duckAdapter = new DuckAdapter(duck);
		duckAdapter.gobble();
		duckAdapter.fly();

	}

}
