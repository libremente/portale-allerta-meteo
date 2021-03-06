create table parer_ComponentiInvio (
	ID_INVIO LONG not null,
	ID_COMPONENTE LONG not null,
	ORDINE_PRESENTAZIONE LONG,
	TIPO_COMPONENTE VARCHAR(75) null,
	TIPO_SUPPORTO_COMPONENTE VARCHAR(75) null,
	NOME_COMPONENTE VARCHAR(128) null,
	FORMATO_FILE_VERSATO VARCHAR(75) null,
	HASH_VERSATO VARCHAR(75) null,
	URN_VERSATO VARCHAR(128) null,
	ID_COMPONENTE_VERSATO LONG,
	primary key (ID_INVIO, ID_COMPONENTE)
);

create table parer_DatiSpecificiInvio (
	ID_INVIO LONG not null primary key,
	AMBIENTE VARCHAR(75) null,
	VERSIONE DOUBLE,
	VERSATORE_ENTE VARCHAR(75) null,
	VERSATORE_USER_ID VARCHAR(75) null,
	VERSATORE_STRUTTURA VARCHAR(75) null,
	CHIAVE_NUMERO VARCHAR(75) null,
	CHIAVE_ANNO LONG,
	CHIAVE_TIPO_REGISTRO VARCHAR(75) null,
	TIPOLOGIA_UNITA_DOCUMENTARIA VARCHAR(75) null,
	TIPO_CONSERVAZIONE VARCHAR(75) null,
	FORZA_ACCETTAZIONE VARCHAR(75) null,
	FORZA_CONSERVAZIONE VARCHAR(75) null,
	FORZA_COLLEGAMENTO VARCHAR(75) null,
	OGGETTO_UNITA_DOCUMENTARIA VARCHAR(1024) null,
	DATA_UNITA_DOCUMENTARIA DATE null,
	VERSIONE_DATI_SPECIFICI DOUBLE,
	IDENTIFICATIVO_DATO_SPECIFICO VARCHAR(75) null,
	DATA_GENERAZIONE DATE null,
	NUM_SMS_GENERATI INTEGER,
	NUM_SMS_INVIATI INTEGER,
	NUM_NOTIFICHE_RICEZIONE INTEGER,
	DENOMINAZIONE_APPLICATIVO VARCHAR(75) null,
	OGGETTO_MAIL VARCHAR(256) null,
	TESTO_MAIL TEXT null,
	COMPILATORE_ARPAE VARCHAR(75) null,
	COMPILATORE_PROTEZIONE_CIVILE VARCHAR(75) null,
	DATA_INIZIO_VALIDITA DATE null,
	DATA_FINE_VALIDITA DATE null,
	APPROVATORE_ARPAE VARCHAR(75) null,
	DATA_FIRMA_ARPAE DATE null,
	APPROVATORE_PROTEZIONE_CIVILE VARCHAR(75) null,
	DATA_FIRMA_PROTEZIONE_CIVILE DATE null,
	INVIO_RESPONSABILE_TERRITORIO VARCHAR(75) null,
	ID_DOCUMENTO_PRINCIPALE LONG,
	TIPO_DOCUMENTO VARCHAR(75) null,
	TIPO_STRUTTURA VARCHAR(75) null,
	DENOMINAZIONE_SENSORE_RILEVAMENTO VARCHAR(75) null,
	REGOLA_ALLARME_ID VARCHAR(75) null,
	REGOLA_ALLARME_NOME VARCHAR(75) null,
	REGOLA_ALLARME_DESCRIZIONE VARCHAR(75) null,
	ESITO_INVIO VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	groupId LONG,
	data_invio DATE null,
	data_risposta DATE null,
	CODICE_ESITO VARCHAR(75) null,
	CODICE_ERRORE VARCHAR(75) null,
	MESG_ERRORE VARCHAR(2048) null,
	CODICE_TIPO_INVIO VARCHAR(75) null
);

create table parer_DocumentiCollegati (
	DOC_COLLEGATO_NUMERO VARCHAR(75) not null,
	DOC_COLLEGATO_ANNO INTEGER not null,
	DOC_COLLEGATO_TIPO_REGISTRO VARCHAR(75) not null,
	DESCRIZIONE_COLLEGAMENTO TEXT null,
	ID_INVIO LONG not null,
	primary key (DOC_COLLEGATO_NUMERO, DOC_COLLEGATO_ANNO, DOC_COLLEGATO_TIPO_REGISTRO, ID_INVIO)
);

create table parer_Parametri (
	chiave VARCHAR(75) not null primary key,
	valore VARCHAR(75) null
);