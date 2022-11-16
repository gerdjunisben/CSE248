package p1;

import java.util.Objects;

public class Captain {
	private String name;
	private static Captain _captain;
	
	private Captain(String name)
	{
		this.name = name;
	}
	
	public static Captain getCaptain(String name)
	{
		if(_captain==null)
		{
			_captain = new Captain(name);
		}
		return _captain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Captain [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Captain other = (Captain) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
	
	
	
}
