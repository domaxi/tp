package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class AddCommand extends Command {
    public AddCommand(Parser parser) {
        super(parser);
    }

    // todo: need ask theo how to implement the storage, now only cr8 cheatsheet got no content

    @Override
    public void execute() throws CommandException {
            String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
            String programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
            String description = parser.getDescriptionMap().get(ArgumentFlagEnum.DESCRIPTION);

            if (name == null) {
                throw new CommandException();
            }

            CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
            CheatSheetList.add(cheatSheet);
            Printer.printAddNewCheatSheetMessage(cheatSheet);
    }
}
