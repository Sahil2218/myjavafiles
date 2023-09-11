import java.util.Scanner;

class Staff {

    String staffId,phone,name,salary;

    public void accept() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Staff Id: ");

        staffId = scanner.next();

        System.out.print("Enter Name: ");

        name = scanner.next();

        System.out.print("Enter Phone: ");

        phone = scanner.next();

        System.out.print("Enter Salary: ");

        salary = scanner.next();

    }

    public void display() {

        System.out.println("Staff Id: " + staffId);

        System.out.println("Name: " + name);

        System.out.println("Phone: " + phone);

        System.out.println("Salary: " + salary);

    }

}

class Teaching extends Staff {

  String domain,publications;

    public void accept() {

        super.accept();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Domain: ");

        domain = scanner.next();

        System.out.print("Enter  Publications: ");
        publications = scanner.next();

    }

    public void display() {

        super.display();

        System.out.println("Domain: " + domain);

        System.out.println("Publications:"+ publications);


    }

}

class Technical extends Staff {

  String skills;

    public void accept() {

        super.accept();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter  Skills: ");

        skills = scanner.next();

    }

    public void display() {

        super.display();

        System.out.println("Skills:"+ skills);


    }

}

class Contract extends Staff {

    private int period;

    public void accept() {

        super.accept();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Period: ");

        period = scanner.nextInt();

    }

    public void display() {

        super.display();

        System.out.println("Period: " + period);

    }

}

class staff_details {

    public static void main(String[] args) {

        Teaching teaching = new Teaching();

        Technical technical = new Technical();

        Contract contract = new Contract();

        System.out.println("Enter Details for Teaching Staff Member");

        teaching.accept();

        System.out.println("Enter Details for Technical Staff Member");

        technical.accept();

        System.out.println("Enter Details for Contract Staff Member");

        contract.accept();

        System.out.println("Details for Teaching Staff Member are");

        teaching.display();

        System.out.println("Details for Technical Staff Member are");

        technical.display();

        System.out.println("Details for Contract Staff Member are");

        contract.display();

    }

}