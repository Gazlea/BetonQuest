package org.betonquest.betonquest.quest.event.command;

import org.betonquest.betonquest.VariableString;
import org.betonquest.betonquest.api.bukkit.command.SilentConsoleCommandSender;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.api.quest.event.Event;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Event that runs given commands in the server console.
 */
public class CommandEvent implements Event {

    /**
     * Command sender to run the commands as.
     * <p>
     * {@link SilentConsoleCommandSender} is used to keep console and log clean.
     */
    private final CommandSender silentSender;

    /**
     * Server to run the commands on.
     */
    private final Server server;

    /**
     * The commands to run.
     */
    private final List<VariableString> commands;

    /**
     * Creates a new CommandEvent.
     *
     * @param commands     the commands to run
     * @param silentSender the command sender to run the commands as
     * @param server       the server to run the commands on
     */
    public CommandEvent(final List<VariableString> commands, final CommandSender silentSender, final Server server) {
        this.silentSender = silentSender;
        this.server = server;
        this.commands = commands;
    }

    @Override
    public void execute(final Profile profile) throws QuestRuntimeException {
        commands.forEach(command -> server.dispatchCommand(silentSender, command.getString(profile)));
    }
}
