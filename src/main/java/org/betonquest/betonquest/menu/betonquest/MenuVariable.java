package org.betonquest.betonquest.menu.betonquest;

import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.Variable;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.menu.OpenedMenu;
import org.bukkit.entity.Player;

/**
 * Returns the title of the players currently opened menu
 */
@SuppressWarnings("PMD.CommentRequired")
public class MenuVariable extends Variable {

    public MenuVariable(final Instruction instruction) throws InstructionParseException {
        super(instruction);
    }

    @Override
    public String getValue(final Profile profile) {
        final Player player = profile.getPlayer();
        final OpenedMenu menu = OpenedMenu.getMenu(player);
        if (menu == null) {
            return "";
        }
        return menu.getData().getTitle(playerID);
    }
}
