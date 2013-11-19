/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.utilities;

/**
 *
 * @author Holywa, MilioPeralta
 */
public enum ProfileExceptionType {
    LoginNull,
    PasswordNull,
    ConnectionWrongLogin,
    ConnectionWrongPassword,
    FileNotFound,
    FileNotAuthorized,
    CreationFileError,
    WritingFileError,
    ExistingFileError,
    ReadingFileError,
    FindingClassUserError,
    DirNotFound,
    LoginWithInvalidCharacters,
    CategoryNotFound,
};