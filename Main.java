import ecs100.UI;
import ecs100.UIButtonListener;

public class Main implements UIButtonListener {
    private UI ui;

    public Main() {
        UI.addButton("Dynamic Programming", this);
        UI.addButton("DNA Generator", this);
        UI.addButton("Quit", this);

        UI.repaintGraphics();
        this.ui = getUIfromECS();
    }

    private static UI getUIfromECS() {
        // Access UI.theUI via reflection since it may not be publicly accessible
        try {
            java.lang.reflect.Field theUIField = UI.class.getDeclaredField("theUI");
            theUIField.setAccessible(true);
            return  (UI) theUIField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void buttonPerformed(String name) {
        UI.clearText();

        switch (name) {
            case "Dynamic Programming":
                DynamicProgramming dpr = new DynamicProgramming(ui, "CAATGTGAATC", "GATCGGCAT");
                dpr.printScoreTable();
                UI.println(dpr.alignmentScore());

                break;
            case "DNA Generator":
                DNAGenerator generator = new DNAGenerator();
                String ancestor = generator.generate(8);
                String descendant1 = generator.mutate(ancestor, 4);
                String descendant2 = generator.mutate(ancestor, 12);
                UI.println("Ancestor:   " + ancestor);
                UI.println("Descendant: " + descendant1);
                UI.println("Descendant: " + descendant2);

                break;
            case "Quit":
                UI.quit();
                break;
            default:
                UI.println("Unknown button: " + name);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
