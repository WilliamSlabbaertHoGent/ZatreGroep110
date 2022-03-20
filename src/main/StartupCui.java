package main;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.DomainController;
import cui.ZatreApplicatie;
import domain.Player;
import persistence.PlayerMapper;

public class StartupCui {
	public static void main(String[] args) {
		ZatreApplicatie zatreApplicatie = new ZatreApplicatie(new DomainController());

		zatreApplicatie.start();
	}
}
