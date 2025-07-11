use yugioh-personalcard-db;

CREATE TABLE storage_location (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
	storage_type VARCHAR(255) NOT NULL,
    notes TEXT
);

CREATE TABLE personal_card (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    card_id VARCHAR(50) NOT NULL,
    language VARCHAR(50) NOT NULL,
    set_code VARCHAR(10) NOT NULL,
    rarity VARCHAR(50) NOT NULL,
    card_condition VARCHAR(50) NOT NULL,
    edition VARCHAR(50) NOT NULL,
    storage_index VARCHAR(255),
    notes TEXT,
    storage_location_id BIGINT NOT NULL,
    FOREIGN KEY (storage_location_id) REFERENCES storage_location(id)
);

insert into storage_location (name,notes,storage_type) values ("Sonstige","Alles was unbekannt oder sonstwas ist","Sonstige");
insert into storage_location (name,notes,storage_type) values ("Sky Striker","ka","Deck");

insert into personal_card (card_id,language,set_code,rarity,card_condition,edition,notes,storage_location_id) values (26077387,"DE","MP19-DE259","Secret","Mint","2","I love Raye",2);