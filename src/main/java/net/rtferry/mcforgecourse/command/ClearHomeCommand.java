package net.rtferry.mcforgecourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ClearHomeCommand {
    public ClearHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("clear").executes(this::execute)));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray("mcforgecourse.homepos").length != 0;

        if(hasHomepos) {
            player.getPersistentData().remove("mcforgecourse.homepos");
            context.getSource().sendSuccess(() -> Component.literal("Home has been cleared"), true);
            return 1;

        } else {
            context.getSource().sendFailure(Component.literal("There is no Home to clear"));
            return -1;
        }
    }
}
