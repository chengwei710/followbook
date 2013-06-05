package com.conway.lohas.persistent.jdodao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class TOPMFactory {
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	private TOPMFactory() {
	}

	public static PersistenceManagerFactory getNewInstance() {
		return pmfInstance;
	}
}
