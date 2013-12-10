	/*
	 * To change this template, choose Tools | Templates
	 * and open the template in the editor.
	 */

	package bitmusic.profile.classes;

	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.UUID;

	import org.jasypt.util.password.ConfigurablePasswordEncryptor;

	import bitmusic.music.data.Song;
	import bitmusic.music.data.SongLibrary;
	import bitmusic.profile.utilities.ProfileExceptionType;
	import bitmusic.profile.utilities.ProfileExceptions;

	/**
	 *
	 * @author reaneyol, MilioPeralta, Jérémy, Fabien
	 */
	public class User implements Serializable {

		//########################## ATTRIBUTES ##########################//
		private static final long serialVersionUID = 402L;
		private String userId;
		private String login;
		private transient String password;
		private Calendar birthDate;
		private String firstName;
		private String lastName;
		private String avatarPath;
		private SongLibrary localSongs;
		private ArrayList<Category> categories;

		//######################### CONSTRUCTORS ###########################//

		/**
		 * Constructor : Create a User with all the parameters
		 * @param login
		 * @param password
		 * @param firstName
		 * @param lastName
		 * @param birthDate
		 * @param avatarPath
		 * @param name  Name of the category
		 */
		public User(String login, String password, String firstName, String lastName, Calendar birthDate, String avatarPath) {
			this.userId = UUID.randomUUID().toString();
			this.login = login;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthDate = birthDate;
			this.avatarPath = avatarPath;
			this.categories = new ArrayList<Category>();
			categories.add(new Category("Default"));
			this.localSongs = new SongLibrary();
		}

		/**
		 * Constructor : Create a User with less parameters
		 * @param login
		 * @param password
		 */
		public User(String login, String password) {
			this(login, password, null, null, null, null);
		}

		//########################### METHODS ##############################//

		/**
		 * Return all the songs of an User
		 * @return localSongs of the User
		 */

		public SongLibrary getLocalSongs() {
			return localSongs;
		}

		/**
		 * Set all the songs of an User
		 * @param localSongs
		 */
		public void setLocalSongs(SongLibrary localSongs) {
			this.localSongs = localSongs;
		}

		/**
		 * Return the UserId of the current User
		 * @return userId
		 */
		public String getUserId() {
			return userId;
		}

		/**
		 * Set the userId of the current User
		 * @param userId
		 * @throws ProfileExceptions
		 */
		public void setUserId(String userId) throws ProfileExceptions {
			if (userId != "") this.userId = userId;
			else throw new ProfileExceptions(ProfileExceptionType.UserIdEmptyName);
		}

		/**
		 * Return the login of the current User
		 * @return login
		 */
		public String getLogin() {
			return login;
		}

		/**
		 * Set the login of the current User
		 * @param login
		 * @throws ProfileExceptions
		 */
		public void setLogin(String login) throws ProfileExceptions{
			if (login != "") this.login = login;
			else throw new ProfileExceptions(ProfileExceptionType.LoginEmptyName);
		}

		/**
		 * Return the password of the current User
		 * @return password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Set the password of the current User
		 * @param password
		 * @throws ProfileExceptions
		 */
		public void setPassword(String password) throws ProfileExceptions{
			if( password != "") this.password = password;
			else throw new ProfileExceptions(ProfileExceptionType.PasswordEmptyName);
		}

		/**
		 * Return the birthdate of the current User
		 * @return birthDate
		 */
		public Calendar getBirthDate() {
			return birthDate;
		}

		/**
		 * Set the birthdate of the current User
		 * @param birthDate
		 * @throws ProfileExceptions
		 */
		public void setBirthDate(Calendar birthDate) throws ProfileExceptions{
			if(birthDate.toString() != "") this.birthDate = birthDate;
			else throw new ProfileExceptions(ProfileExceptionType.BirthdateEmptyName);
		}

		/**
		 * Return the fistname of the current User
		 * @return firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * Set the firstname of the current User
		 * @param firstName
		 * @throws ProfileExceptions
		 */
		public void setFirstName(String firstName) throws ProfileExceptions{
			if(firstName != "") this.firstName = firstName;
			else throw new ProfileExceptions(ProfileExceptionType.FirstNameNullOrEmpty);
		}

		/**
		 * Return the lastname of the current User
		 * @return lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * Set the lastname of the current User
		 * @param lastName
		 * @throws ProfileExceptions
		 */
		public void setLastName(String lastName) throws ProfileExceptions{
			if(lastName != "") this.lastName = lastName;
			else throw new ProfileExceptions(ProfileExceptionType.LastNameNullOrEmpty);
		}

		/**
		 * Return the avatar path of the avatar of the current User
		 * @return avatarPath
		 */
		public String getAvatarPath() {
			return avatarPath;
		}

		/**
		 * Set the avatar path of the avatar of the current User
		 * @param avatarPath
		 * @throws ProfileExceptions
		 */
		public void setAvatarPath(String avatarPath) throws ProfileExceptions{
			if(avatarPath != "") this.avatarPath = avatarPath;
			else throw new ProfileExceptions(ProfileExceptionType.AvatarPathEmpty);
		}

		/**
		 * Return all the categories of the current User
		 * @return categories
		 */
		public ArrayList<Category> getCategories() {
			return categories;
		}

		/**
		 * Return the User's category which id is categoryId
		 * @param categoryId
		 * @return cat
		 * @throws ProfileExceptions
		 */
		public Category getCategoryById(String categoryId) throws ProfileExceptions {
			for(Category cat : this.categories) {
				if(cat.getId().equals(categoryId)) {
					return cat;
				}
			}
			throw new ProfileExceptions(ProfileExceptionType.CategoryNotFound);
		}

		/**
		 * Set the User's catagories to categories
		 * @param categories
		 */
		public void setCategories(ArrayList<Category> categories) {
			this.categories = categories;
		}

		/**
		 * Return the contact which id is userId in the current User's categories
		 * @param userId
		 * @return usr
		 * @throws ProfileExceptions
		 */
		public User getContact(String userId) throws ProfileExceptions{
			for (Category cat : categories) {
				User usr = cat.findContact(userId);
				if (usr != null)
						return usr;
			}
			return null;
		}

		/**
		 * Add the category which name is name
		 * @param name
		 * @throws ProfileExceptions
		 */
		public void addCategory(String name) throws ProfileExceptions {
			if(!name.equals(""))
				categories.add(new Category(name));
			else
				throw new ProfileExceptions(ProfileExceptionType.CategoryEmptyName);
		}

		/**
		 * Update the category which is id categoryId and replace its name to newName
		 * @param categoryId
		 * @param newName
		 * @throws ProfileExceptions
		 */
		public void updateCategory(String categoryId,
				String newName) throws ProfileExceptions {
		   if(!newName.equals(""))
			   this.getCategoryById(categoryId).setName(newName);
		   else
			   throw new ProfileExceptions(ProfileExceptionType.CategoryEmptyName);
		}

		/**
		 * Delete the category of id categoryId
		 * @param categoryId
		 * @throws ProfileExceptions
		 */
		public void deleteCategory(String categoryId) throws ProfileExceptions {
			categories.remove(this.getCategoryById(categoryId));
		}

		/**
		 * Add the contact user in the category which category is categoryId
		 * @param user
		 * @param categoryId
		 * @throws ProfileExceptions
		 */
		public void addContact(User user, String categoryId) throws ProfileExceptions {
			this.getCategoryById(categoryId).addUser(user);
		}

		/**
		 * Remove the contact user which is in the category which id is categoryId
		 * @param user
		 * @param categoryId
		 * @throws ProfileExceptions
		 */
		public void removeContact(User user, String categoryId) throws ProfileExceptions {
			 this.getCategoryById(categoryId).deleteUser(user);
		}

		/**
		 * Add the song song
		 * @param song
		 */
		public void addSong(Song song) {
			this.localSongs.addSong(song);
		}

		/**
		 * Delete the song which id is songId
		 * @param songId
		 * @throws ProfileExceptions
		 */
		public void deleteSong(String songId) throws ProfileExceptions{
			if(!songId.equals(""))
				this.localSongs.removeSong(songId);
			else
				throw new ProfileExceptions(ProfileExceptionType.SongEmptyName);
		}

		/**
		 * Print info about the current User
		 * @return string
		 */
		@Override
		public String toString() {
			return "Login : " + this.login + "\nUserID : " + this.userId + "\n";
		}

		/**
		 * Format the birthdate to be used in the folder name
		 *
		 * @return date
		 */
		public String getTransformedBirthday() {
			int year = this.birthDate.get(Calendar.YEAR);
			int month = this.birthDate.get(Calendar.MONTH) + 1;
			int day = this.birthDate.get(Calendar.DAY_OF_MONTH);
			return String.format("%04d", year)
					+ String.format("%02d", month)
					+ String.format("%02d", day);
		}

		/**
		 * Return the encrypted password using SHA-1
		 *
		 * @return password
		 */
		public String getEncryptedPassword() {
			ConfigurablePasswordEncryptor pwdEncryptor = new ConfigurablePasswordEncryptor();
		pwdEncryptor.setAlgorithm("SHA-1");
		return pwdEncryptor.encryptPassword(password);
		}

		/**
		 * Return the name of the current User's folder
		 * @return foldername
		 */
		public String getFolderName() {
		return login + "_" + getTransformedBirthday();
		}

		/**
		 * Fonction to test the class User
		 *
		 * @param o
		 * @return
		 */
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof User)) return false;
			User user = (User) o;
			return this.login      == user.login     &&
				   this.password   == user.password  &&
				   this.firstName  == user.firstName &&
				   this.lastName   == user.lastName  &&
				   this.birthDate  == user.birthDate &&
				   this.avatarPath == user.avatarPath;
		}
	}
