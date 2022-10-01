package theme_09_IteratorsAndComaparators.Exercises.P08_PetClinics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Clinic implements Iterable<Pet> {
    private String name;
    private Pet[] rooms;
    private int centralRoomIndex;

    public Clinic(String name, int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.name = name;
        rooms = new Pet[numberOfRooms];
        this.centralRoomIndex = numberOfRooms / 2;

    }


    public boolean add(Pet pet) {
        int index = centralRoomIndex;
        int step = 1;
        int direction = -1;

        while (index >= 0 && index < this.rooms.length) {
            if (this.rooms[index] == null) {
                this.rooms[index] = pet;
                return true;
            }
            index = index + step * direction;
            step++;
            direction *= (-1);
        }

        return false;
    }

    public boolean release() {
        int index = centralRoomIndex;

        for (int circle = 0; circle < rooms.length; circle++) {
            if (rooms[index] != null) {
                rooms[index] = null;
                return true;
            }
            index++;
            if (index == rooms.length) {
                index = 0;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet room : rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRooms() {
        return rooms.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < rooms.length;
            }

            @Override
            public Pet next() {
                Pet pet = rooms[index];
                index++;
                return pet;
            }
        };
    }

    public String roomToString(int index) {
        Pet pet = rooms[index];
        if (pet == null) {
            return "Room empty";
        } else {
            return String.format("%s %d %s", pet.getName(), pet.getAge(), pet.getKind());
        }
    }

    public String roomToString(Pet pet) {
        if (pet == null) {
            return "Room empty";
        } else {
            return String.format("%s %d %s", pet.getName(), pet.getAge(), pet.getKind());
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(rooms).map(this::roomToString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
