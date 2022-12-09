package Model;


public class College {
    private String id;
    private String name;
    private String city;
    private String zip;
    private double admissionRate;
    private double completionRate;
    private int inStateTuition;
    private int outStateTuition;
    private int population;
    private String ownership;
    

    public College(String id,String name,String city,String zip,
    double admissionRate,double completionRate,int inStateTuition,int outStateTuition
    ,int population, String ownership)
    {
        this.id=id;
        this.name=name;
        this.city=city;
        this.zip=zip;
        this.admissionRate = admissionRate;
        this.completionRate = completionRate;
        this.inStateTuition = inStateTuition;
        this.outStateTuition = outStateTuition;
        this.population = population;
        this.ownership = ownership;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    public String getZip()
    {
        return zip;
    }

    public String getAdmissionRate()
    {
    	return String.format("%2.2f",admissionRate*100) + "%";
    }

    public void setAdmissionRate(double admissionRate)
    {
        this.admissionRate = admissionRate;
    }

    public String getCompletionRate()
    {
        return String.format("%2.2f",completionRate*100)+ "%";
    }

    public void setCompletionRate(double completionRate)
    {
        this.completionRate = completionRate;
    }

    public String getInStateTuition()
    {
        return "$" + String.format("%,d",inStateTuition);
    }

    public void setInStateTuition(int inStateTuition)
    {
        this.inStateTuition = inStateTuition;
    }

    public String getOutStateTuition()
    {
        return "$" + String.format("%,d",outStateTuition);
    }

    public void setOutStateTuition(int outStateTuition)
    {
        this.outStateTuition = outStateTuition;
    }
    
    
    

    public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getPopulation() {
		return String.format("%,d",population);
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String toString()
    {
        return String.format("Id:%-10s,Name:%-50s,City:%-20s,Zip:%-15s,Admission:%-15s,Completion:%-15s,InState Tuition:%-20s,OutState Tuition:%-20s,Population:%-10s,Ownership:%-10s",id,name,city,zip,getAdmissionRate(),getCompletionRate(),getInStateTuition(),getOutStateTuition(),getPopulation(),getOwnership());
    }
}
