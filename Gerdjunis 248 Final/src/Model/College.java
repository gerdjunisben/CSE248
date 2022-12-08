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
    

    public College(String id,String name,String city,String zip,
    double admissionRate,double completionRate,int inStateTuition,int outStateTuition)
    {
        this.id=id;
        this.name=name;
        this.city=city;
        this.zip=zip;
        this.admissionRate = admissionRate;
        this.completionRate = completionRate;
        this.inStateTuition = inStateTuition;
        this.outStateTuition = outStateTuition;
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
    
    

    public String toString()
    {
        return String.format("%10s , %50s , %20s , %15s , %15s , %20s , %20s",id,name.strip(),city,zip,getAdmissionRate(),getCompletionRate(),getInStateTuition(),getOutStateTuition());
    }
}
