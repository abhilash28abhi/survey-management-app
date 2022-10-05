CREATE TABLE surveys (
   survey_id INT NOT NULL AUTO_INCREMENT,
   description VARCHAR(100) ,
   type VARCHAR(50),
   status VARCHAR(10),
   created_date TIMESTAMP,
   PRIMARY KEY (survey_id)
);

CREATE TABLE questions (
   question_id INT NOT NULL AUTO_INCREMENT,
   survey_id INT NOT NULL,
   description VARCHAR(250) ,
   active BIT,
   created_date TIMESTAMP,
   PRIMARY KEY (question_id),
   FOREIGN KEY (survey_id) REFERENCES surveys(survey_id)
);

CREATE TABLE options (
   option_id INT NOT NULL AUTO_INCREMENT,
   question_id INT NOT NULL,
   description VARCHAR(250) ,
   created_date TIMESTAMP,
   PRIMARY KEY (option_id),
   FOREIGN KEY (question_id) REFERENCES questions(question_id)
);

CREATE TABLE responses (
   response_id INT NOT NULL AUTO_INCREMENT,
   survey_id INT NOT NULL,
   question_id INT NOT NULL,
   option_id INT NOT NULL,
   PRIMARY KEY (response_id),
   FOREIGN KEY (survey_id) REFERENCES surveys(survey_id),
   FOREIGN KEY (question_id) REFERENCES questions(question_id),
   FOREIGN KEY (option_id) REFERENCES options(option_id)
);