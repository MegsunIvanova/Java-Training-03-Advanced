package theme_09_IteratorsAndComaparators.Exercises.P08_PetClinics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();

        while (numberOfCommands-- > 0) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];

            switch (command) {
                case "Create":
                    if (commandLine[1].equals("Pet")) {
                        String petName = commandLine[2];
                        int age = Integer.parseInt(commandLine[3]);
                        String kind = commandLine[4];
                        Pet pet = new Pet(petName, age, kind);
                        pets.add(pet);
                    } else if (commandLine[1].equals("Clinic")) {
                        String clinicName = commandLine[2];
                        int rooms = Integer.parseInt(commandLine[3]);

                        try {
                            Clinic clinic = new Clinic(clinicName, rooms);
                            clinics.add(clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petNameForAdding = commandLine[1];
                    String clinicNameForAdding = commandLine[2];
                    Pet pet = getPetByName(petNameForAdding, pets);
                    Clinic clinicForAdding = getClinicByName(clinicNameForAdding, clinics);
                    if (pet != null && clinicForAdding != null) {
                        System.out.println(clinicForAdding.add(pet));
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "Release":
                    String clinicNameForReleasing = commandLine[1];
                    Clinic clinicForReleasing = getClinicByName(clinicNameForReleasing, clinics);
                    if (clinicForReleasing != null) {
                        System.out.println(clinicForReleasing.release());
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "HasEmptyRooms":
                    String clinicName = commandLine[1];
                    Clinic clinic = getClinicByName(clinicName, clinics);
                    if (clinic != null) {
                        System.out.println(clinic.hasEmptyRooms());
                    }
                    break;
                case "Print":
                    String clinicNameForPrint = commandLine[1];
                    Clinic clinicForPrint = getClinicByName(clinicNameForPrint, clinics);
                    if (commandLine.length == 2 && clinicForPrint != null) {
                        System.out.println(clinicForPrint);
                    } else if (commandLine.length == 3 && clinicForPrint != null) {
                        int roomIndex = Integer.parseInt(commandLine[2]) - 1;
                        if (roomIndex >= 0 && roomIndex < clinicForPrint.getNumberOfRooms()) {
                            System.out.println(clinicForPrint.roomToString(roomIndex));
                        }
                    }
                    break;
            }
        }

    }

    private static Pet getPetByName(String petName, List<Pet> pets) {
        for (Pet pet : pets) {
            if (pet.getName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }

    private static Clinic getClinicByName(String clinicName, List<Clinic> clinics) {
        for (Clinic clinic : clinics) {
            if (clinic.getName().equals(clinicName)) {
                return clinic;
            }
        }
        return null;
    }
}
