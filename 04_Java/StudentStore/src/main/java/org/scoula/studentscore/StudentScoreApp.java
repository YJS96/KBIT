package org.scoula.studentscore;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.studentscore.command.GetScoresCommand;
import org.scoula.studentscore.command.InitScoresCommand;

public class StudentScoreApp extends App {
    @Override
    public void createMenu(Menu menu) {
        menu.add(new MenuItem("학생수", ));
        menu.add(new MenuItem("점수입력", new GetScoresCommand()))
    }

    public static void main(String[] args) {
        App app = new StudentScoreApp();
        app.run();
    }
}
