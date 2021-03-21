package org.example.tomcat1.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.example.tomcat1.controller.command.impl.action.ChangeLocal;
import org.example.tomcat1.controller.command.impl.action.DeleteNews;
import org.example.tomcat1.controller.command.impl.action.Login;
import org.example.tomcat1.controller.command.impl.action.Logout;
import org.example.tomcat1.controller.command.impl.action.ModifyNews;
import org.example.tomcat1.controller.command.impl.action.SaveUser;
import org.example.tomcat1.controller.command.impl.gotopage.GoToEditPage;
import org.example.tomcat1.controller.command.impl.gotopage.GoToIndexPage;
import org.example.tomcat1.controller.command.impl.gotopage.GoToMainPage;
import org.example.tomcat1.controller.command.impl.gotopage.GoToNewsPage;
import org.example.tomcat1.controller.command.impl.gotopage.GoToRedirectPage;
import org.example.tomcat1.controller.command.impl.gotopage.GoToRegistrationPage;

public final class CommandProvider {
	private Map<CommandName, ICommand> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.LOGIN, new Login());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.SAVEUSER, new SaveUser());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
		commands.put(CommandName.MODIFYNEWS, new ModifyNews());
		commands.put(CommandName.CHANGELOCAL, new ChangeLocal());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.GOTONEWSPAGE, new GoToNewsPage());
		commands.put(CommandName.GOTOEDITPAGE, new GoToEditPage());
		commands.put(CommandName.GOTOREGISTRATIONPAGE,
				new GoToRegistrationPage());
		commands.put(CommandName.GOTOREDIRECTPAGE,
				new GoToRedirectPage());
	}

	public ICommand takeCommand(final String name) {
		CommandName commandName = CommandName.valueOf(
				name.toUpperCase());

		return commands.get(commandName);
	}
}
