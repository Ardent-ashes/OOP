class bank{
    String name;
    List<Customer>customers;
    List<Employee>employees;

    bank()
    {
        this.name=name;
        this.customers=new ArrayList<>();
        this.employees= new ArrayList<>();
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    void printbank()
    {
        System.out.println(this.name+" Bank created ");
    }
}
