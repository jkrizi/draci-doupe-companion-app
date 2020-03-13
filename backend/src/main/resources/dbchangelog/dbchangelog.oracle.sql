--liquibase formatted sql

--changeset Jiri.Kriz1:1576766708146-1
CREATE TABLE ABILITY_SCORE (ID RAW(16) NOT NULL, ABILITY VARCHAR2(15 BYTE) NOT NULL, VALUE NUMBER(3, 0) NOT NULL, BONUS NUMBER(3, 0) NOT NULL, BEAST_BLUEPRINT_ID RAW(16), PERSON_ID RAW(16), CONSTRAINT ABILITY_SCORE_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-2
CREATE TABLE ARMOR (ID RAW(16) NOT NULL, DEFENSE NUMBER(3, 0) NOT NULL, EQUIPPED NUMBER(1, 0) NOT NULL, CONSTRAINT ARMORY_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-3
CREATE TABLE ARMOR_BLUEPRINT (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, PUBLIC_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, WEIGHT NUMBER(6, 0) NOT NULL, DEFENSE NUMBER(3, 0) NOT NULL, PRIVATE_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, CONSTRAINT ARMOR_BLUEPRINT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-4
CREATE TABLE ARMOR_COVERAGE (BODY_SECTION VARCHAR2(25 BYTE) NOT NULL, ARMOR_ID RAW(16) NOT NULL, CONSTRAINT ARMOR_COVERAGE_PK PRIMARY KEY (BODY_SECTION, ARMOR_ID));

--changeset Jiri.Kriz1:1576766708146-5
CREATE TABLE ARMOR_COVERAGE_BLUEPRINT (BODY_SECTION VARCHAR2(25 BYTE) NOT NULL, ARMOR_BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT ARMOR_COVERAGE_BLUEPRINT_PK PRIMARY KEY (BODY_SECTION, ARMOR_BLUEPRINT_ID));

--changeset Jiri.Kriz1:1576766708146-6
CREATE TABLE BEAST (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, LIFE NUMBER(5, 0) NOT NULL, BEAST_SIZE VARCHAR2(2 BYTE) NOT NULL, BEAST_BLUEPRINT_ID RAW(16) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, INVENTORY_ID RAW(16) NOT NULL, ATTACK NUMBER(3, 0) NOT NULL, HURT NUMBER(3, 0) NOT NULL, ACTIVE_DEFENSE NUMBER(3, 0) NOT NULL, PASSIVE_DEFENSE NUMBER(3, 0) NOT NULL, INITIATIVE_BASE NUMBER(3, 0) NOT NULL, CONSTRAINT BEAST_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-7
CREATE TABLE BEAST_BLUEPRINT (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, SPECIES VARCHAR2(50 BYTE) NOT NULL, VIABILITY NUMBER(4, 0) NOT NULL, VIABILITY_BONUS NUMBER(4, 0) NOT NULL, MANNA NUMBER(6, 0) NOT NULL, MOBILITY NUMBER(3, 0) NOT NULL, PUGNACITY NUMBER(3, 0) NOT NULL, PERSISTENCE NUMBER(3, 0) NOT NULL, DOMESTICATION NUMBER(3, 0) NOT NULL, TRAINED NUMBER(1, 0) NOT NULL, INVENTORY_ID RAW(16) NOT NULL, BEAST_ORIGIN VARCHAR2(50 BYTE) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, ATTACK NUMBER(3, 0) NOT NULL, HURT NUMBER(3, 0) NOT NULL, ACTIVE_DEFENSE NUMBER(3, 0) NOT NULL, PASSIVE_DEFENSE NUMBER(3, 0) NOT NULL, INITIATIVE_BASE NUMBER(3, 0) NOT NULL, CONSTRAINT BEAST_BLUEPRINT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-8
CREATE TABLE BEAST_SIZE (CHARACTER_SIZE VARCHAR2(2 BYTE) NOT NULL, BEAST_BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT BEAST_SIZE_PK PRIMARY KEY (CHARACTER_SIZE, BEAST_BLUEPRINT_ID));

--changeset Jiri.Kriz1:1576766708146-9
CREATE TABLE BEAST_VULNERABILITY (VULNERABILITY VARCHAR2(2 BYTE) NOT NULL, BEAST_BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT BEAST_VULNERABILITY_PK PRIMARY KEY (VULNERABILITY, BEAST_BLUEPRINT_ID));

--changeset Jiri.Kriz1:1576766708146-10
CREATE TABLE COHERENCE (ID RAW(16) NOT NULL, PERSON_ID RAW(16) NOT NULL, COMMON_LEVELS NUMBER(3, 0) NOT NULL, WARRIOR_KNOWHOW_ID RAW(16) NOT NULL, CONSTRAINT COHERENCE_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-11
CREATE TABLE ENCOUNTER (NR_OF_ENCOUNTERS NUMBER(5, 0) NOT NULL, WARRIOR_KNOWHOW_ID RAW(16) NOT NULL, ID RAW(16) NOT NULL, BEAST_BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT ENCOUNTER_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-12
CREATE TABLE EQUIPMENT (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, WEIGHT NUMBER(6, 0) NOT NULL, STORAGE_UNIT_ID RAW(16), ITEM_TYPE VARCHAR2(50 BYTE) NOT NULL, BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT EQUIPMENT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-13
CREATE TABLE GEMSTONE (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, COLOR VARCHAR2(50 BYTE) NOT NULL, UNIT_PRICE FLOAT(22) NOT NULL, CONSTRAINT GEMSTONE_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-14
CREATE TABLE GOODS_BLUEPRINT (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, PUBLIC_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, PRIVATE_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, WEIGHT NUMBER(6, 0) NOT NULL, ITEM_TYPE VARCHAR2(25 BYTE) NOT NULL, CONSTRAINT GOODS_BLUEPRINT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-15
CREATE TABLE HT_ARMOR (ID RAW(255) NOT NULL);

--changeset Jiri.Kriz1:1576766708146-16
CREATE TABLE HT_EQUIPMENT (ID RAW(255) NOT NULL);

--changeset Jiri.Kriz1:1576766708146-17
CREATE TABLE HT_STORAGE_UNIT (ID RAW(255) NOT NULL);

--changeset Jiri.Kriz1:1576766708146-18
CREATE TABLE HT_TREASURE (ID RAW(255) NOT NULL);

--changeset Jiri.Kriz1:1576766708146-19
CREATE TABLE HT_WEAPON (ID RAW(255) NOT NULL);

--changeset Jiri.Kriz1:1576766708146-20
CREATE TABLE INVENTORY (ID RAW(16) NOT NULL, LIMIT_WEIGHT NUMBER(6, 0) NOT NULL, CONTENT_WEIGHT NUMBER(6, 0) NOT NULL, COIN_POUCH FLOAT(22) NOT NULL, BANK_VAULT FLOAT(22) NOT NULL, CONSTRAINT INVENTORY_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-21
CREATE TABLE LOCAL_PRICE (ID RAW(16) NOT NULL, PRICE FLOAT(22) NOT NULL, DEAL_LOCATION VARCHAR2(50 BYTE) NOT NULL, SHOP_ITEM_ID RAW(16) NOT NULL, CONSTRAINT LOCAL_PRICE_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-22
CREATE TABLE PERSON (ID RAW(16) NOT NULL, PERSON_BLUEPRINT_ID RAW(16), NAME VARCHAR2(25 BYTE) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE), PERSON_LEVEL NUMBER(3, 0) NOT NULL, EXP NUMBER(9, 0) NOT NULL, CURRENT_LIFE NUMBER(4, 0) NOT NULL, MAXIMAL_LIFE NUMBER(4, 0) NOT NULL, CURRENT_MANNA NUMBER(4, 0) NOT NULL, MAXIMAL_MANNA NUMBER(4, 0) NOT NULL, WEIGHT NUMBER(6, 0) NOT NULL, HEIGHT NUMBER(4, 0) NOT NULL, PROFESSION_KNOWHOW_ID RAW(16) NOT NULL, ATTACK NUMBER(3, 0) NOT NULL, HURT NUMBER(3, 0) NOT NULL, ACTIVE_DEFENSE NUMBER(3, 0) NOT NULL, PASSIVE_DEFENSE NUMBER(3, 0) NOT NULL, INITIATIVE_BASE NUMBER(3, 0) NOT NULL, INVENTORY_ID RAW(16) NOT NULL, RACE_ID RAW(16) NOT NULL, CONSTRAINT PERSON_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-23
CREATE TABLE PERSON_BLUEPRINT (ID RAW(16) NOT NULL, NAME VARCHAR2(25 BYTE) NOT NULL, DESCRIPTION VARCHAR2(250 BYTE), PERSON_LEVEL NUMBER(2, 0) NOT NULL, RACE_ID RAW(16) NOT NULL, PROFESSION VARCHAR2(25 BYTE) NOT NULL, INVENTORY_ID RAW(16) NOT NULL, CONSTRAINT PERSON_BLUEPRINT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-24
CREATE TABLE PROFESSION_KNOWHOW (ID RAW(16) NOT NULL, PROFESSION VARCHAR2(50 BYTE) NOT NULL, PYROKINESIS_LEVEL_LEARNED NUMBER(3, 0) NOT NULL, TELEKINESIS_LEVEL_LEARNED NUMBER(3, 0) NOT NULL, TELEPATHY_LEVEL_LEARNED NUMBER(3, 0) NOT NULL, CONSTRAINT PROFESSION_KNOWHOW_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-25
CREATE TABLE RACE (ID RAW(16) NOT NULL, NAME VARCHAR2(25 BYTE) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, RACE_SIZE VARCHAR2(1 BYTE) NOT NULL, MIN_WEIGHT NUMBER(5, 0) NOT NULL, MAX_WEIGHT NUMBER(5, 0) NOT NULL, MIN_HEIGHT NUMBER(5, 0) NOT NULL, MAX_HEIGHT NUMBER(5, 0) NOT NULL, WEAPON_ID RAW(16) NOT NULL, STRENGTH_NR_OF_THROWS NUMBER(2, 0) NOT NULL, DEXTERITY_NR_OF_THROWS NUMBER(2, 0) NOT NULL, RESISTANCE_NR_OF_THROWS NUMBER(2, 0) NOT NULL, INTELLIGENCE_NR_OF_THROWS NUMBER(2, 0) NOT NULL, CHARISMA_NR_OF_THROWS NUMBER(2, 0) NOT NULL, STRENGTH_ABILITY_BASE NUMBER(2, 0) NOT NULL, DEXTERITY_ABILITY_BASE NUMBER(2, 0) NOT NULL, RESISTANCE_ABILITY_BASE NUMBER(2, 0) NOT NULL, INTELLIGENCE_ABILITY_BASE NUMBER(2, 0) NOT NULL, CHARISMA_ABILITY_BASE NUMBER(2, 0) NOT NULL, STRENGTH_ABILITY_CORRECTION NUMBER(2, 0) NOT NULL, DEXTERITY_ABILITY_CORRECTION NUMBER(2, 0) NOT NULL, RESISTANCE_ABILITY_CORRECTION NUMBER(2, 0) NOT NULL, INTELLIGENCE_ABILITY_CORRECTION NUMBER(2, 0) NOT NULL, CHARISMA_ABILITY_CORRECTION NUMBER(2, 0) NOT NULL, CONSTRAINT RACE_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-26
CREATE TABLE SHOP_ITEM (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, ITEM_TYPE VARCHAR2(25 BYTE) NOT NULL, BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT SHOP_ITEM_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-27
CREATE TABLE SKILL (ID RAW(16) NOT NULL, NAME VARCHAR2(25 BYTE) NOT NULL, DIFFICULTY VARCHAR2(25 BYTE) NOT NULL, ABILITY VARCHAR2(25 BYTE) NOT NULL, FULL_SUCCESS VARCHAR2(500 BYTE) NOT NULL, SUCCESS VARCHAR2(500 BYTE) NOT NULL, FAILURE VARCHAR2(500 BYTE) NOT NULL, FATAL_FAILURE VARCHAR2(500 BYTE) NOT NULL, CONSTRAINT SKILL_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-28
CREATE TABLE SKILL_KNOWHOW (ID RAW(16) NOT NULL, POINTS_TOTAL NUMBER(4, 0) NOT NULL, POINTS_FOR_NEXT_LEVEL NUMBER(4, 0) NOT NULL, SKILL_KNOWLEDGE VARCHAR2(25 BYTE) NOT NULL, SKILL_ID RAW(16) NOT NULL, CONSTRAINT SKILL_KNOWHOW_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-29
CREATE TABLE SPELL (ID RAW(16) NOT NULL, NAME VARCHAR2(25 BYTE) NOT NULL, DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, MANNA_COST NUMBER(3, 0) NOT NULL, RANGE_OR_DIAMETER NUMBER(4, 0) NOT NULL, CONJURING NUMBER(4, 0) NOT NULL, DURATION NUMBER(4, 0) NOT NULL, CONSTRAINT SPELL_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-30
CREATE TABLE SPELLBOOK (ID RAW(16) NOT NULL, WIZARD_KNOWHOW_ID RAW(16) NOT NULL, SPELL_ID RAW(16) NOT NULL, CONSTRAINT SPELLBOOK_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-31
CREATE TABLE STORAGE_UNIT (ID RAW(16) NOT NULL, STORAGE_CAPACITY NUMBER(6, 0) NOT NULL, CONTENT_WEIGHT NUMBER(6, 0) NOT NULL, INVENTORY_ID RAW(16) NOT NULL, DEFAULT_STORAGE NUMBER(1, 0) NOT NULL, CONSTRAINT STORAGE_UNIT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-32
CREATE TABLE TREASURE_BLUEPRINT (ID RAW(16) NOT NULL, NAME VARCHAR2(50 BYTE) NOT NULL, PUBLIC_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, PRIVATE_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, STONE_WEIGHT NUMBER(6, 0) NOT NULL, TREASURE_VALUE FLOAT(22) NOT NULL, MATERIAL VARCHAR2(50 BYTE) NOT NULL, MATERIAL_WEIGHT NUMBER(6, 0) NOT NULL, PRODUCT_QUALITY VARCHAR2(50 BYTE) NOT NULL, GEMSTONE_ID RAW(16) NOT NULL, POLISHED NUMBER(1, 0) NOT NULL, CONSTRAINT TREASURE_BLUEPRINT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-33
CREATE TABLE WEAPON (ID RAW(16) NOT NULL, ATTACK NUMBER(3, 0) NOT NULL, HURT NUMBER(3, 0) NOT NULL, DEFENSE NUMBER(3, 0) NOT NULL, MIN_MELEE_REACH NUMBER(2, 0) NOT NULL, MAX_MELEE_REACH NUMBER(2, 0) NOT NULL, EQUIPPED NUMBER(1, 0) NOT NULL, INITIATIVE_MODIFIER NUMBER(3, 0) NOT NULL, SHORT_RANGE_LIMIT NUMBER(6, 0) NOT NULL, MID_RANGE_LIMIT NUMBER(6, 0) NOT NULL, LONG_RANGE_LIMIT NUMBER(6, 0) NOT NULL, CONSTRAINT WEAPONRY_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-34
CREATE TABLE WEAPONTYPE_PROFICIENCY (ID RAW(16) NOT NULL, NR_OF_LEVELS_USED NUMBER(3, 0) NOT NULL, WARRIOR_KNOWHOW_ID RAW(16) NOT NULL, WEAPON_BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT WEAPONTYPE_PROFICIENCY_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-35
CREATE TABLE WEAPON_BLUEPRINT (ID RAW(16) NOT NULL, NAME VARCHAR2(25 BYTE) NOT NULL, PUBLIC_DESCRIPTION VARCHAR2(250 BYTE) NOT NULL, WEIGHT NUMBER(6, 0) NOT NULL, ATTACK NUMBER(3, 0) NOT NULL, HURT NUMBER(3, 0) NOT NULL, DEFENSE NUMBER(3, 0) NOT NULL, INITIATIVE_MODIFIER NUMBER(3, 0) NOT NULL, SHORT_RANGE_LIMIT NUMBER(6, 0) NOT NULL, MID_RANGE_LIMIT NUMBER(6, 0) NOT NULL, LONG_RANGE_LIMIT NUMBER(6, 0) NOT NULL, MIN_MELEE_REACH NUMBER(2, 0) NOT NULL, MAX_MELEE_REACH NUMBER(2, 0) NOT NULL, PRIVATE_DESCRIPTION VARCHAR2(500 BYTE) NOT NULL, CONSTRAINT WEAPON_BLUEPRINT_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-36
CREATE TABLE WEAPON_PROFICIENCY (ID RAW(16) NOT NULL, EXPERIENCE_EARNED NUMBER(6, 0) NOT NULL, WARRIOR_KNOWHOW_ID RAW(16) NOT NULL, WEAPON_ID RAW(16) NOT NULL, CONSTRAINT WEAPON_PROFICIENCY_PK PRIMARY KEY (ID));

--changeset Jiri.Kriz1:1576766708146-37
CREATE TABLE WEAPON_TYPE (WEAPON_TYPE VARCHAR2(25 BYTE) NOT NULL, WEAPON_ID RAW(16) NOT NULL, CONSTRAINT WEAPON_TYPE_PK PRIMARY KEY (WEAPON_TYPE, WEAPON_ID));

--changeset Jiri.Kriz1:1576766708146-38
CREATE TABLE WEAPON_TYPE_BLUEPRINT (WEAPON_TYPE VARCHAR2(25 BYTE) NOT NULL, WEAPON_BLUEPRINT_ID RAW(16) NOT NULL, CONSTRAINT WEAPON_TYPE_BLUEPRINT_PK PRIMARY KEY (WEAPON_TYPE, WEAPON_BLUEPRINT_ID));

--changeset Jiri.Kriz1:1576766708146-39
ALTER TABLE ABILITY_SCORE ADD CONSTRAINT ABILITY_SCORE_BEAST_BLUEPRINT_ID_FK FOREIGN KEY (BEAST_BLUEPRINT_ID) REFERENCES BEAST_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-40
ALTER TABLE ABILITY_SCORE ADD CONSTRAINT ABILITY_SCORE_PERSON_ID_FK FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID);

--changeset Jiri.Kriz1:1576766708146-41
ALTER TABLE ARMOR_COVERAGE ADD CONSTRAINT ARMOR_COVERAGE_ARMOR_ID_FK FOREIGN KEY (ARMOR_ID) REFERENCES ARMOR (ID);

--changeset Jiri.Kriz1:1576766708146-42
ALTER TABLE ARMOR_COVERAGE_BLUEPRINT ADD CONSTRAINT ARMOR_COVERAGE_BLUEPRINT_ARMOR_BLUEPRINT_ID_FK FOREIGN KEY (ARMOR_BLUEPRINT_ID) REFERENCES ARMOR_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-43
ALTER TABLE ARMOR ADD CONSTRAINT ARMOR_EQUIPMENT_ID_FK FOREIGN KEY (ID) REFERENCES EQUIPMENT (ID);

--changeset Jiri.Kriz1:1576766708146-44
ALTER TABLE BEAST ADD CONSTRAINT BEAST_BEAST_BLUEPRINT_ID_FK FOREIGN KEY (BEAST_BLUEPRINT_ID) REFERENCES BEAST_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-45
ALTER TABLE BEAST_BLUEPRINT ADD CONSTRAINT BEAST_BLUEPRINT_INVENTORY_ID_FK FOREIGN KEY (INVENTORY_ID) REFERENCES INVENTORY (ID);

--changeset Jiri.Kriz1:1576766708146-46
ALTER TABLE BEAST ADD CONSTRAINT BEAST_INVENTORY_ID_FK FOREIGN KEY (INVENTORY_ID) REFERENCES INVENTORY (ID);

--changeset Jiri.Kriz1:1576766708146-47
ALTER TABLE BEAST_SIZE ADD CONSTRAINT BEAST_SIZE_BEAST_BLUEPRINT_ID_FK FOREIGN KEY (BEAST_BLUEPRINT_ID) REFERENCES BEAST_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-48
ALTER TABLE BEAST_VULNERABILITY ADD CONSTRAINT BEAST_VULNERABILITY_BEAST_BLUEPRINT_ID_FK FOREIGN KEY (BEAST_BLUEPRINT_ID) REFERENCES BEAST_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-49
ALTER TABLE COHERENCE ADD CONSTRAINT COHERENCE_PERSON_ID_FK FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID);

--changeset Jiri.Kriz1:1576766708146-50
ALTER TABLE COHERENCE ADD CONSTRAINT COHERENCE_PROFESSION_KNOWHOW_ID_FK FOREIGN KEY (WARRIOR_KNOWHOW_ID) REFERENCES PROFESSION_KNOWHOW (ID);

--changeset Jiri.Kriz1:1576766708146-51
ALTER TABLE ENCOUNTER ADD CONSTRAINT ENCOUNTER_BEAST_BLUEPRINT_ID_FK FOREIGN KEY (BEAST_BLUEPRINT_ID) REFERENCES BEAST_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-52
ALTER TABLE ENCOUNTER ADD CONSTRAINT ENCOUNTER_PROFESSION_KNOWHOW_ID_FK FOREIGN KEY (WARRIOR_KNOWHOW_ID) REFERENCES PROFESSION_KNOWHOW (ID);

--changeset Jiri.Kriz1:1576766708146-53
ALTER TABLE EQUIPMENT ADD CONSTRAINT EQUIPMENT_STORAGE_UNIT_ID_FK FOREIGN KEY (STORAGE_UNIT_ID) REFERENCES STORAGE_UNIT (ID);

--changeset Jiri.Kriz1:1576766708146-54
ALTER TABLE LOCAL_PRICE ADD CONSTRAINT LOCAL_PRICE_SHOP_ITEM_ID_FK FOREIGN KEY (SHOP_ITEM_ID) REFERENCES SHOP_ITEM (ID);

--changeset Jiri.Kriz1:1576766708146-55
ALTER TABLE PERSON_BLUEPRINT ADD CONSTRAINT PERSON_BLUEPRINT_INVENTORY_ID_FK FOREIGN KEY (INVENTORY_ID) REFERENCES INVENTORY (ID);

--changeset Jiri.Kriz1:1576766708146-56
ALTER TABLE PERSON_BLUEPRINT ADD CONSTRAINT PERSON_BLUEPRINT_RACE_ID_FK FOREIGN KEY (RACE_ID) REFERENCES RACE (ID);

--changeset Jiri.Kriz1:1576766708146-57
ALTER TABLE PERSON ADD CONSTRAINT PERSON_INVENTORY_ID_FK FOREIGN KEY (INVENTORY_ID) REFERENCES INVENTORY (ID);

--changeset Jiri.Kriz1:1576766708146-58
ALTER TABLE PERSON ADD CONSTRAINT PERSON_PERSON_BLUEPRINT_ID_FK FOREIGN KEY (PERSON_BLUEPRINT_ID) REFERENCES PERSON_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-59
ALTER TABLE PERSON ADD CONSTRAINT PERSON_PROFESSION_KNOWHOW_ID_FK FOREIGN KEY (PROFESSION_KNOWHOW_ID) REFERENCES PROFESSION_KNOWHOW (ID);

--changeset Jiri.Kriz1:1576766708146-60
ALTER TABLE PERSON ADD CONSTRAINT PERSON_RACE_ID_FK FOREIGN KEY (RACE_ID) REFERENCES RACE (ID);

--changeset Jiri.Kriz1:1576766708146-61
ALTER TABLE RACE ADD CONSTRAINT RACE_WEAPONRY_ID_FK FOREIGN KEY (WEAPON_ID) REFERENCES WEAPON (ID);

--changeset Jiri.Kriz1:1576766708146-62
ALTER TABLE SKILL_KNOWHOW ADD CONSTRAINT SKILL_KNOWHOW_SKILL_ID_FK FOREIGN KEY (SKILL_ID) REFERENCES SKILL (ID);

--changeset Jiri.Kriz1:1576766708146-63
ALTER TABLE SPELLBOOK ADD CONSTRAINT SPELLBOOK_PROFESSION_KNOWHOW_ID_FK FOREIGN KEY (WIZARD_KNOWHOW_ID) REFERENCES PROFESSION_KNOWHOW (ID);

--changeset Jiri.Kriz1:1576766708146-64
ALTER TABLE SPELLBOOK ADD CONSTRAINT SPELLBOOK_SPELL_ID_FK FOREIGN KEY (SPELL_ID) REFERENCES SPELL (ID);

--changeset Jiri.Kriz1:1576766708146-65
ALTER TABLE STORAGE_UNIT ADD CONSTRAINT STORAGE_UNIT_EQUIPMENT_ID_FK FOREIGN KEY (ID) REFERENCES EQUIPMENT (ID);

--changeset Jiri.Kriz1:1576766708146-66
ALTER TABLE STORAGE_UNIT ADD CONSTRAINT STORAGE_UNIT_INVENTORY_ID_FK FOREIGN KEY (INVENTORY_ID) REFERENCES INVENTORY (ID);

--changeset Jiri.Kriz1:1576766708146-67
ALTER TABLE TREASURE_BLUEPRINT ADD CONSTRAINT TREASURE_BLUEPRINT_GEMSTONE_ID_FK FOREIGN KEY (GEMSTONE_ID) REFERENCES GEMSTONE (ID);

--changeset Jiri.Kriz1:1576766708146-68
ALTER TABLE WEAPONTYPE_PROFICIENCY ADD CONSTRAINT WEAPONTYPE_PROFICIENCY_PROFESSION_KNOWHOW_ID_FK FOREIGN KEY (WARRIOR_KNOWHOW_ID) REFERENCES PROFESSION_KNOWHOW (ID);

--changeset Jiri.Kriz1:1576766708146-69
ALTER TABLE WEAPONTYPE_PROFICIENCY ADD CONSTRAINT WEAPONTYPE_PROFICIENCY_WEAPON_BLUEPRINT_ID_FK FOREIGN KEY (WEAPON_BLUEPRINT_ID) REFERENCES WEAPON_BLUEPRINT (ID);

--changeset Jiri.Kriz1:1576766708146-70
ALTER TABLE WEAPON ADD CONSTRAINT WEAPON_EQUIPMENT_ID_FK FOREIGN KEY (ID) REFERENCES EQUIPMENT (ID);

--changeset Jiri.Kriz1:1576766708146-71
ALTER TABLE WEAPON_PROFICIENCY ADD CONSTRAINT WEAPON_PROFICIENCY_PROFESSION_KNOWHOW_ID_FK FOREIGN KEY (WARRIOR_KNOWHOW_ID) REFERENCES PROFESSION_KNOWHOW (ID);

--changeset Jiri.Kriz1:1576766708146-72
ALTER TABLE WEAPON_PROFICIENCY ADD CONSTRAINT WEAPON_PROFICIENCY_WEAPON_ID_FK FOREIGN KEY (WEAPON_ID) REFERENCES WEAPON (ID);

--changeset Jiri.Kriz1:1576766708146-73
ALTER TABLE WEAPON_TYPE ADD CONSTRAINT WEAPON_TYPE_WEAPON_ID_FK FOREIGN KEY (WEAPON_ID) REFERENCES WEAPON (ID);

--changeset Jiri.Kriz1:1576766708146-74
alter table EQUIPMENT modify BLUEPRINT_ID null;

--changeset Jan.Zatloukal:1576766708146-75
alter table TREASURE_BLUEPRINT rename column GEMSTONE_ID to GEM_STONE_ID;

--changeset Jiri.Kriz1:1576766708146-76
rename GEMSTONE to GEM_STONE_BLUEPRINT;

--changeset Jiri.Kriz1:1576766708146-77
create table GEM_STONE
(
  ID RAW(16) not null
    constraint GEM_STONE_pk
      primary key,
  STONE_WEIGHT NUMBER(6) not null,
  STONE_PRICE FLOAT(22) not null,
  POLISHED NUMBER(1) not null,
  TREASURE_BLUEPRINT_ID RAW(16) not null
    constraint GEM_STONE_TREASURE_BLUEPRINT_ID_fk
      references TREASURE_BLUEPRINT,
  GEM_STONE_BLUEPRINT_ID RAW(16) not null
    constraint GEM_STONE_GEM_STONE_BLUEPRINT_ID_fk
      references GEM_STONE_BLUEPRINT
);

--changeset Jiri.Kriz1:1576766708146-78
alter table BEAST_BLUEPRINT rename column TRAINED to SCHOOLED;

--changeset Jiri.Kriz1:1576766708146-79
alter table BEAST_BLUEPRINT rename column BEAST_ORIGIN to ORIGIN;

--changeset Jiri.Kriz1:1576766708146-80
alter table SPELL rename column MANNA_COST to MANNA;

--changeset Jiri.Kriz1:1576766708146-81
alter table SPELL rename column RANGE_OR_DIAMETER to RANGE;


--changeset Jan.Zatloukal:1576766708146-82
alter table TREASURE_BLUEPRINT drop column STONE_WEIGHT;

--changeset Jan.Zatloukal:1576766708146-83
alter table TREASURE_BLUEPRINT drop column POLISHED;

--changeset Jiri.Kriz1:1576766708146-84
create table SWORD_MOVE
(
  ID RAW(16) not null
    constraint SWORD_MOVE_pk
      primary key,
  NAME VARCHAR2(25) not null,
  DESCRIPTION VARCHAR2(250) not null,
  INITIATIVE NUMBER(3) not null,
  ACTIONS NUMBER(2) not null,
  HUMANOID_OPPONENT NUMBER(1) not null
);

--changeset Jiri.Kriz1:1576766708146-85
create table SWORD_MOVE_USER_WEAPON
(
  WEAPON_TYPE VARCHAR2(25) not null,
  SWORD_MOVE_ID RAW(16) not null
    constraint SWORD_MOVE_USER_WEAPON_SWORD_MOVE_ID_fk
      references SWORD_MOVE,
  constraint SWORD_MOVE_USER_WEAPON_pk
    primary key (WEAPON_TYPE, SWORD_MOVE_ID)
);

--changeset Jiri.Kriz1:1576766708146-86
create table SWORD_MOVE_OPPONENT_WEAPON
(
  WEAPON_TYPE VARCHAR2(25) not null,
  SWORD_MOVE_ID RAW(16) not null
    constraint SWORD_MOVE_OPPONENT_WEAPON_SWORD_MOVE_ID_fk
      references SWORD_MOVE,
  constraint SWORD_MOVE_OPPONENT_WEAPON_pk
    primary key (WEAPON_TYPE, SWORD_MOVE_ID)
);

--changeset Jiri.Kriz1:1576766708146-87
create table WEAPON_FAMILY
(
  ID RAW(16) not null
    constraint WEAPON_FAMILY_pk
      primary key,
  WEAPON_FAMILY_NAME VARCHAR2(25) not null,
  IS_MELEE NUMBER(1) not null,
  IS_SINGLE_HANDED NUMBER(1) not null,
  WEIGHT_CATEGORY VARCHAR2(25) not null,
  WEAPON_DAMAGE_TYPE VARCHAR2(25) not null
);

--changeset Jiri.Kriz1:1576766708146-88
alter table WEAPON_BLUEPRINT
  add WEAPON_FAMILY_ID RAW(16) not null;

--changeset Jiri.Kriz1:1576766708146-89
alter table WEAPON_BLUEPRINT
  add constraint WEAPON_BLUEPRINT_WEAPON_FAMILY_ID_fk
    foreign key (WEAPON_FAMILY_ID) references WEAPON_FAMILY;

--changeset Jiri.Kriz1:1576766708146-90
drop table WEAPON_TYPE;

--changeset Jiri.Kriz1:1576766708146-91
drop table WEAPON_TYPE_BLUEPRINT;

--changeset Jiri.Kriz1:1576766708146-92
drop table SWORD_MOVE_OPPONENT_WEAPON;

--changeset Jiri.Kriz1:1576766708146-93
drop table SWORD_MOVE_USER_WEAPON;

--changeset Jiri.Kriz1:1576766708146-94
create table SWORD_MOVE_USER_WEAPON
(
  ID RAW(16) not null
    constraint SWORD_MOVE_USER_WEAPON_pk
      primary key,
  SWORD_MOVE_ID RAW(16) not null
    constraint SWORD_MOVE_USER_WEAPON_SWORD_MOVE_ID_fk
      references SWORD_MOVE,
  WEAPON_FAMILY_ID RAW(16) not null
    constraint SWORD_MOVE_USER_WEAPON_WEAPON_FAMILY_ID_fk
      references WEAPON_FAMILY
);

--changeset Jiri.Kriz1:1576766708146-95
create table SWORD_MOVE_OPPONENT_WEAPON
(
  ID RAW(16) not null
    constraint SWORD_MOVE_OPPONENT_WEAPON_pk
      primary key,
  SWORD_MOVE_ID RAW(16) not null
    constraint SWORD_MOVE_OPPONENT_WEAPON_SWORD_MOVE_ID_fk
      references SWORD_MOVE,
  WEAPON_FAMILY_ID RAW(16) not null
    constraint SWORD_MOVE_OPPONENT_WEAPON_WEAPON_FAMILY_ID_fk
      references WEAPON_FAMILY
);

--changeset Jiri.Kriz1:1576766708146-96
alter table ARMOR_BLUEPRINT add "ARMOR_SIZE" VARCHAR2(25) not null;

--changeset Jiri.Kriz1:1576766708146-97
rename GEM_STONE_BLUEPRINT to GEMSTONE_BLUEPRINT;

--changeset Jiri.Kriz1:1576766708146-98
create table DAMAGE_TYPE
(
  WEAPON_FAMILY_ID RAW(16) not null
    constraint DAMAGE_TYPE_WEAPON_FAMILY_ID_fk
      references WEAPON_FAMILY,
  DAMAGE_TYPE VARCHAR2(25) not null,
  constraint DAMAGE_TYPE_pk
    primary key (WEAPON_FAMILY_ID, DAMAGE_TYPE)
);

--changeset Jiri.Kriz1:1576766708146-99
alter table WEAPON_FAMILY rename column WEAPON_FAMILY_NAME to NAME;

--changeset Jiri.Kriz1:1576766708146-100
alter table WEAPON_FAMILY rename column WEAPON_DAMAGE_TYPE to DAMAGE_TYPE;

--changeset Jiri.Kriz1:1576766708146-101
alter table WEAPON_FAMILY drop column DAMAGE_TYPE;

--changeset Jan.Zatloukal:1576766708146-102
alter table WEAPON
  add Type_ID RAW(16) not null;

--changeset Jan.Zatloukal:1576766708146-103
alter table TREASURE_BLUEPRINT
  add GOLD_VALUE FLOAT(22) not null;

--changeset Jan.Zatloukal:1576766708146-104
alter table TREASURE_BLUEPRINT
  add SILVER_VALUE FLOAT(22) not null;

--changeset Jan.Zatloukal:1576766708146-105
alter table TREASURE_BLUEPRINT
  add COPPER_VALUE FLOAT(22) not null;

--changeset Jan.Zatloukal:1576766708146-106
alter table TREASURE_BLUEPRINT drop column TREASURE_VALUE;

--changeset Jan.Zatloukal:1576766708146-107
alter table TREASURE_BLUEPRINT drop constraint TREASURE_BLUEPRINT_GEMSTONE_ID_FK;

--changeset Jiri.Kriz:1576766708146-108
alter table RACE drop constraint RACE_WEAPONRY_ID_FK;

--changeset Jiri.Kriz:1576766708146-109
alter table RACE rename column STRENGTH_NR_OF_THROWS to STRENGTH_THROWS;

--changeset Jiri.Kriz:1576766708146-110
alter table RACE rename column DEXTERITY_NR_OF_THROWS to DEXTERITY_THROWS;

--changeset Jiri.Kriz:1576766708146-111
alter table RACE rename column RESISTANCE_NR_OF_THROWS to RESISTANCE_THROWS;

--changeset Jiri.Kriz:1576766708146-112
alter table RACE rename column INTELLIGENCE_NR_OF_THROWS to INTELLIGENCE_THROWS;

--changeset Jiri.Kriz:1576766708146-113
alter table RACE rename column CHARISMA_NR_OF_THROWS to CHARISMA_THROWS;

--changeset Jiri.Kriz:1576766708146-114
alter table RACE rename column STRENGTH_ABILITY_BASE to STRENGTH_BASE;

--changeset Jiri.Kriz:1576766708146-115
alter table RACE rename column DEXTERITY_ABILITY_BASE to DEXTERITY_BASE;

--changeset Jiri.Kriz:1576766708146-116
alter table RACE rename column RESISTANCE_ABILITY_BASE to RESISTANCE_BASE;

--changeset Jiri.Kriz:1576766708146-117
alter table RACE rename column INTELLIGENCE_ABILITY_BASE to INTELLIGENCE_BASE;

--changeset Jiri.Kriz:1576766708146-118
alter table RACE rename column CHARISMA_ABILITY_BASE to CHARISMA_BASE;

--changeset Jiri.Kriz:1576766708146-119
alter table RACE rename column STRENGTH_ABILITY_CORRECTION to STRENGTH_CORRECTION;

--changeset Jiri.Kriz:1576766708146-120
alter table RACE rename column DEXTERITY_ABILITY_CORRECTION to DEXTERITY_CORRECTION;

--changeset Jiri.Kriz:1576766708146-121
alter table RACE rename column RESISTANCE_ABILITY_CORRECTION to RESISTANCE_CORRECTION;

--changeset Jiri.Kriz:1576766708146-122
alter table RACE rename column INTELLIGENCE_ABILITY_CORRECTION to INTELLIGENCE_CORRECTION;

--changeset Jiri.Kriz:1576766708146-123
alter table RACE rename column CHARISMA_ABILITY_CORRECTION to CHARISMA_CORRECTION;

--changeset Jiri.Kriz:1576766708146-124
alter table GEM_STONE drop constraint GEM_STONE_GEM_STONE_BLUEPRINT_ID_FK;

--changeset Jiri.Kriz:1576766708146-125
alter table GEM_STONE drop constraint GEM_STONE_TREASURE_BLUEPRINT_ID_FK;

--changeset Jiri.Kriz:1576766708146-126
rename GEM_STONE to GEMSTONE;

--changeset Jiri.Kriz:1576766708146-127
alter table GEMSTONE
  add constraint GEM_STONE_GEM_STONE_BLUEPRINT_ID_FK
    foreign key (GEM_STONE_BLUEPRINT_ID) references GEMSTONE_BLUEPRINT;

--changeset Jiri.Kriz:1576766708146-128
alter table GEMSTONE
  add constraint GEM_STONE_TREASURE_BLUEPRINT_ID_FK
    foreign key (TREASURE_BLUEPRINT_ID) references TREASURE_BLUEPRINT;

--changeset Jiri.Kriz:1576766708146-129
alter table GEMSTONE rename column STONE_WEIGHT to WEIGHT;

--changeset Jiri.Kriz:1576766708146-130
alter table GEMSTONE rename column STONE_PRICE to PRICE;

--changeset Jiri.Kriz:1576766708146-131
alter table GEMSTONE rename column GEM_STONE_BLUEPRINT_ID to GEMSTONE_BLUEPRINT_ID;

--changeset Jiri.Kriz:1576766708146-132
alter table TREASURE_BLUEPRINT rename column GEM_STONE_ID to GEMSTONE_ID;

--changeset Jiri.Kriz:1576766708146-133
alter table TREASURE_BLUEPRINT drop column GEMSTONE_ID;

--changeset Jiri.Kriz:1576766708146-134
alter table GEMSTONE add COUNT NUMBER(6) not null;

--changeset Jiri.Kriz:1576766708146-135
drop table SWORD_MOVE_OPPONENT_WEAPON;

--changeset Jiri.Kriz:1576766708146-136
drop table SWORD_MOVE_USER_WEAPON;

--changeset Jiri.Kriz:1576766708146-137
create table SWORD_MOVE_WEAPON_USER
(
  SWORD_MOVE_ID RAW(16) not null
    constraint SWORD_MOVE_WEAPON_USER_SWORD_MOVE_ID_fk
      references SWORD_MOVE,
  WEAPON_FAMILY_ID RAW(16) not null
    constraint SWORD_MOVE_WEAPON_USER_WEAPON_FAMILY_ID_fk
      references WEAPON_FAMILY,
  constraint SWORD_MOVE_WEAPON_USER_pk
    primary key (SWORD_MOVE_ID, WEAPON_FAMILY_ID)
);

--changeset Jiri.Kriz:1576766708146-138
create table SWORD_MOVE_WEAPON_OPPONENT
(
  SWORD_MOVE_ID RAW(16) not null
    constraint SWORD_MOVE_WEAPON_OPPONENT_SWORD_MOVE_ID_fk
      references SWORD_MOVE,
  WEAPON_FAMILY_ID RAW(16) not null
    constraint SWORD_MOVE_WEAPON_OPPONENT_WEAPON_FAMILY_ID_fk
      references WEAPON_FAMILY,
  constraint SWORD_MOVE_WEAPON_OPPONENT_pk
    primary key (SWORD_MOVE_ID, WEAPON_FAMILY_ID)
);
