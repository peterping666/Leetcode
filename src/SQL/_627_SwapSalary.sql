update salary set sex= CHAR(ASCII('f') + ASCII('m') - ASCII(sex));

update salary set sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));
