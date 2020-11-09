/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Letsoaloblessing2@gmail.com
 */
public class userPD {

    private String surname, firstname, phone, date, fav_food;
    private String option_eat, answer_eat, option_movies, answer_movies, option_tv, answer_tv,
            option_radio, answer_radio;
    private int age;

    //
    public userPD() {

        surname = firstname = phone = date = fav_food ="";
        option_eat=answer_eat=option_movies=answer_movies=option_tv=answer_tv=option_radio=answer_radio;
        age = 5;
    }

    
    //Overlaoded method for varaibles

    public userPD(String surname, String firstname, String phone,
                  String date,int age, String fav_food, String option_eat,
                  String answer_eat, String option_movies, String answer_movies,
                  String option_tv, String answer_tv, String option_radio, String answer_radio) {
        
        setSurname(surname);
        setFirstname(firstname);
        setPhone(phone);
        setDate(date);
        setAge(age);
        setFav_food(fav_food);
        setOption_eat(option_eat);
        setAnswer_eat(answer_eat);
        setOption_movies(option_movies);
        setAnswer_movies(answer_movies);
        setOption_tv(option_tv);
        setAnswer_tv(answer_tv);
        setOption_radio(option_radio);
        setAnswer_radio(answer_radio);
        
        
    }
    

    //Getter methods for varaibles
    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public String getFav_food() {
        return fav_food;
    }

    public String getOption_eat() {
        return option_eat;
    }

    public String getAnswer_eat() {
        return answer_eat;
    }

    public String getOption_movies() {
        return option_movies;
    }

    public String getAnswer_movies() {
        return answer_movies;
    }

    public String getOption_tv() {
        return option_tv;
    }

    public String getAnswer_tv() {
        return answer_tv;
    }

    public String getOption_radio() {
        return option_radio;
    }

    public String getAnswer_radio() {
        return answer_radio;
    }

   

    public int getAge() {
        return age;
    }

    //Setter methods for varaibles
    public void setSurname(String surname) {

        if (surname.length() <= 0 || surname.equalsIgnoreCase("")) {

            throw new IllegalArgumentException("Fill in Surname !!");
        } else {

            this.surname = surname;
        }

    }

    public void setFirstname(String firstname) {

        if (firstname.length() <= 0 || firstname.equalsIgnoreCase("")) {

            throw new IllegalArgumentException("Fill in Firstname !!");
        } else {

            this.firstname = firstname;
        }

    }

    public void setPhone(String phone) {
        if (phone.length() <= 0 || phone.equalsIgnoreCase("")) {

            throw new IllegalArgumentException("Fill in Contact number !!");
        } else {

            this.phone = phone;
        }

    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFav_food(String fav_food) {
        this.fav_food = fav_food;
    }

    public void setOption_eat(String option_eat) {
        this.option_eat = option_eat;
    }

    public void setAnswer_eat(String answer_eat) {
        this.answer_eat = answer_eat;
    }

    public void setOption_movies(String option_movies) {
        this.option_movies = option_movies;
    }

    public void setAnswer_movies(String answer_movies) {
        this.answer_movies = answer_movies;
    }

    public void setOption_tv(String option_tv) {
        this.option_tv = option_tv;
    }

    public void setAnswer_tv(String answer_tv) {
        this.answer_tv = answer_tv;
    }

    public void setOption_radio(String option_radio) {
        this.option_radio = option_radio;
    }

    public void setAnswer_radio(String answer_radio) {
        this.answer_radio = answer_radio;
    }

    public void setAge(int age) {

        if (age < 5 || age > 120) {

            throw new IllegalArgumentException("Invalid age!!");
        } else {

            this.age = age;
        }

    }

    public void initConnection() throws DataStorageException {

        userDA.initConnection();
    }

    public void addUser(userPD objUser) throws DuplicateException {

        userDA.addUser(objUser);
    }
    
    public int cntSurvey() throws NotFoundException {
    
        return userDA.cntSurvey();
    }
    
    public  double AverageAge() throws NotFoundException {
    
        return userDA.AverageAge();
    }
    public int minAge() throws NotFoundException {
    
        return userDA.minAge();
    }
    
    public int maxAge() throws NotFoundException {
    
        return userDA.maxAge();
    }
    public int cntPizza() throws NotFoundException {
        
        return userDA.cntPizza();
    }
    public int cntPasta() throws NotFoundException {
        
        return userDA.cntPasta();
    }
    public int cntPap() throws NotFoundException {
    
        return userDA.cntPap();
    }

    public void terminate() throws DataStorageException {

        userDA.terminate();
    }
}
