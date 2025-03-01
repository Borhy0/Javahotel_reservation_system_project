package hotel_reservation_system_project;

class Service {
    enum serviceName {
        Spa, Gym, Breakfast;
    }

    private serviceName sName;
    private int servicePrice;
    private static int serviceUsage = 0;
    private static int serviceCountSpa = 0;
    private static int serviceCountGym = 0;
    private static int serviceCountBreakfast = 0;

    public Service(serviceName sName, int servicePrice) {
        this.sName = sName;
        this.servicePrice = servicePrice;
        switch (sName) {
            case Gym:
                serviceCountGym++;
                break;
            case Spa:
                serviceCountSpa++;
                break;
            case Breakfast:
                serviceCountBreakfast++;
                break;
        }
        serviceUsage++;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public static int getServiceCountSpa() {
        return serviceCountSpa;
    }

    public static int getServiceCountGym() {
        return serviceCountGym;
    }

    public static int getServiceCountBreakfast() {
        return serviceCountBreakfast;
    }

    public static int getServiceUsage() {
        return serviceUsage;
    }

    public serviceName getServiceName() {
        return sName;
    }
     public String offerService(Person person) {
        if (person instanceof Admin) {
            return offerToAdmin((Admin) person);
        } else if (person instanceof Employee) {
            return offerToEmployee((Employee) person);
        } else if (person instanceof Customer) {
            return offerToCustomer((Customer) person);
        } else {
            return "Service cannot be offered to this type of person.";
        }
    }

    private String offerToAdmin(Admin admin) {
        return "Offering a premium service to Admin: " + admin.getName()+" disscount on any service 25%";
    }

    private String offerToEmployee(Employee employee) {
        return "Offering a discounted service to Employee: " + employee.getName()+" disscount on any service 15%";
    }

    private String offerToCustomer(Customer customer) {
        return "Offering a standard service to Customer: " + customer.getName()+" disscount on any service 10%";
    }
}   