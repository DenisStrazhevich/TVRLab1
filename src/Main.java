import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<FamousActor> famousActorList = new ArrayList<FamousActor>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1 - add, 2 - output");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        addActor();
                        break;
                    case 2:
                        consoleOutput();
                        break;
                    default:
                        break;
                }
            }

    }

    public static boolean check(String name){
        for (int i = 0; i < name .length(); i++) {
            if(!Character.isLetter(name.charAt(i))){
                System.out.println("This string doesn't contain only letters!" + "\n" );
                return false;
            }
        }
        return true;
    }

    public static void addActor(){
        String name = null;
        String surname = null;
        int age = 0;
        String country = null;
        try {
            System.out.println("Enter the name of actor");
            while(scanner.hasNextInt() || scanner.hasNextDouble() || check(name = scanner.next()) == false ){
                System.out.println("Uncurrect input!");
                scanner.next();
            }
            System.out.println("Enter the surname of actor");
            while(scanner.hasNextInt() || scanner.hasNextDouble() || check(surname = scanner.next()) == false ){
                System.out.println("Uncurrect input!");
                scanner.next();
            }
            System.out.println("Enter the age of actor");
            while(!scanner.hasNextInt()){
                System.out.println("Uncurrect input!");
                scanner.next();
            }
            age = scanner.nextInt();
            System.out.println("Enter the country of actor");
            while(scanner.hasNextInt() || scanner.hasNextDouble() || check(country = scanner.next()) == false ){
                System.out.println("Uncurrect input!");
                scanner.next();
            }
        } catch (Exception e){
            System.out.println("Error!" + e);
        }
        famousActorList.add(new FamousActor(name,surname,age,country));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Java\\TVRLab1\\temp.txt")))
        {

            oos.writeObject(famousActorList);
            System.out.println("File has been written");


        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void consoleOutput() {
        ArrayList<FamousActor> newFamousActorList= new ArrayList<FamousActor>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Java\\TVRLab1\\temp.txt")))
        {

            newFamousActorList=((ArrayList<FamousActor>)ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        for(FamousActor famousActor : newFamousActorList)
            System.out.printf(famousActor.toString() + "\n");
    }



}
