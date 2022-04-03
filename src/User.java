class User {
    private String name;
    private int age;
    private String username;
    private int phone;

    public User(String name, int age, String username, int phone) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public double getPhone() {
        return phone;
    }
}