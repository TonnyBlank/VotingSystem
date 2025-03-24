import java.util.*;

public class VotingSystem {

    private static HashMap<String, Integer> candidates = new HashMap<>();
   
    private static HashSet<String> voters = new HashSet<>();

    private static void vote(Scanner scanner) {
        System.out.print("Enter your voter ID/REG NO: ");
        String voterID = scanner.nextLine().trim();

        if (voters.contains(voterID)) {
            System.out.println("You have already voted. Multiple votes are not allowed.");
            return;
        }

        System.out.println("Candidates:");
        for (String candidate : candidates.keySet()) {
            System.out.println("- " + candidate);
        }
        System.out.print("Enter the name of the candidate you want to vote for: ");
        String vote = scanner.nextLine().trim();

        String selectedCandidate = null;
        for (String candidate : candidates.keySet()) {
            if (candidate.equalsIgnoreCase(vote)) {
                selectedCandidate = candidate;
                break;
            }
        }

        if (selectedCandidate != null) {
            candidates.put(selectedCandidate, candidates.get(selectedCandidate) + 1);
            voters.add(voterID);
            System.out.println("Vote cast successfully for " + selectedCandidate + "!");
        } else {
            System.out.println("Invalid candidate. Write the name of the candidate.");
        }
    }

   
    private static void showResults() {
        System.out.println("\nVoting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        candidates.put("Mercelene Nyaboke", 0);
        candidates.put("Joy Hilda", 0);

        System.out.println("Welcome to the Voting System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Vote");
            System.out.println("2. View Results");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    vote(scanner);
                    break;
                case 2:
                    showResults();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you for participating!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
