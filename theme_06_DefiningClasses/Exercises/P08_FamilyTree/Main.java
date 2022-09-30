package theme_06_DefiningClasses.Exercises.P08_FamilyTree;

import java.util.*;

public class Main {
    public static List<Person> familyMembers = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String mainPersonInfo = scanner.nextLine();
        familyMembers.add(new Person(mainPersonInfo));

        ArrayDeque<String> inputQueueForRelations = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains(" - ")) {
                //the person on the left is the parent of the person on the right
                inputQueueForRelations.offer(input);

            } else {
                //the person with that name was born on that date
                String name = input.split("\\s+")[0] + " " + input.split("\\s+")[1];
                String birthdate = input.split("\\s+")[2];

                if (mainPersonInfo.equals(name) || mainPersonInfo.equals(birthdate)) {
                    familyMembers.get(0).setName(name);
                    familyMembers.get(0).setBirthdate(birthdate);
                } else {
                    familyMembers.add(new Person(name, birthdate));
                }
            }

            input = scanner.nextLine();
        }


        while (!inputQueueForRelations.isEmpty()) {
            String[] relationData = inputQueueForRelations.poll().split(" - ");
            String parentData = relationData[0];
            String childData = relationData[1];
            Person parent = getMember(parentData);
            Person child = getMember(childData);
            parent.addChild(child);
            child.addParent(parent);

        }

        System.out.println(familyMembers.get(0));

    }

    private static Person getMember(String personInfo) {
        for (Person familyMember : familyMembers) {
            String memberName = familyMember.getName();
            String memberBirthday = familyMember.getBirthdate();
            if (personInfo.equals(memberName) || personInfo.equals(memberBirthday)) {
                return familyMember;
            }
        }

        Person person = new Person(personInfo);
        familyMembers.add(person);
        return person;
    }


}
