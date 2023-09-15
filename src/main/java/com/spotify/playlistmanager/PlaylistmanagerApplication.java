package com.spotify.playlistmanager;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spotify.playlistmanager.commands.CommandRegistry;

@SpringBootApplication
public class PlaylistmanagerApplication implements CommandLineRunner{

	private Scanner scanner;
	private CommandRegistry commandRegistry;

	public PlaylistmanagerApplication(CommandRegistry commandRegistry)
	{
		scanner = new Scanner(System.in);
		this.commandRegistry = commandRegistry;
	}

	@Override
	public void run(String... args) throws Exception {
		while(true)
		{
			System.out.println("Tell me what to do:");
			String input = scanner.nextLine();
			commandRegistry.excecute(input);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaylistmanagerApplication.class, args);
	}
}
