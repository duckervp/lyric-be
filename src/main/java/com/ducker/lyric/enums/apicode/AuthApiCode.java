package com.ducker.lyric.enums.apicode;

import com.ducker.lyric.base.ApiCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AuthApiCode implements ApiCode {

    USER_NOT_FOUND(2, "User not found"),
    USER_NOT_FOUND_WITH_GIVEN_EMAIL(2, "User not found with given email"),
    USER_NOT_FOUND_WITH_GIVEN_ID(3, "User not found with given id"),
    EMAIL_IS_IN_USED(4, "Email is in used"),
    EMAIL_IS_NOT_EXIST(5, "Email is not exist"),
    METAMASK_LOGIN_FAIL(6, "Metamask login fail"),
    TELEGRAM_LOGIN_FAIL(7, "Telegram login fail"),
    REFRESH_TOKEN_EXPIRED(8, "Refresh token expired. Please signin again."),
    INVALID_REFRESH_TOKEN(9, "Invalid refresh token"),
    INVALID_GOOGLE_CODE(11, "Invalid Google code"),
    INVALID_GOOGLE_TOKEN(12, "Invalid Google token"),
    GIVEN_PASSWORD_EXPIRED(13, "Given password expired"),
    GIVEN_PASSWORD_INCORRECT(14, "Given password is incorrect"),
    INVALID_TOKEN(15, "Invalid token"),
    TOKEN_EXPIRED(16, "Token expired"),
    RECAPTCHA_SERVER_TIMEOUT(17, "Recaptcha sever timeout"),
    INVALID_RECAPTCHA(18, "Invalid recaptcha"),
    CANNOT_CREATE_USER(19, "Cannot create user"),
    USERNAME_IS_IN_USED(20, "Username is in used"),
    THIS_FIELD_IS_REQUIRED(21, "This field is required"),
    AVATAR_URL_IS_REQUIRED(21, "Avatar url is required"),
    INVALID_EMAIL(22, "Invalid email"),
    NO_ACCOUNT_ASSOCIATED_WITH_EMAIL(23, "There is not an account associated with this email"),
    ACCOUNT_BANNED(24, "Your account has been suspended. Please contact our admin for support"),
    GIVEN_PASSWORD_REQUIRED(25, "Given Password is required"),
    NEW_PASSWORD_REQUIRED(28, "New Password is required"),
    PASSWORD_CONFIRMATION_REQUIRED(29, "Password Confirmation is required"),
    INVALID_PASSWORD(30, "Invalid password"),
    PASSWORD_CONFIRM_MUST_BE_SAME_NEW_PASSWORD(31, "Password Confirmation must be the same as New Password"),
    USERNAME_CANNOT_CONTAIN_SPACE(32, "Username cannot contain space"),
    USERNAME_IS_REQUIRED(33, "Username is required"),
    NAME_IS_REQUIRED(33, "Username is required"),
    USERNAME_LENGTH_INVALID(34, "Characters length mus be 3-64"),
    EMAIL_IS_REQUIRED(36, "Email is required"),
    PASSWORD_IS_REQUIRED(37, "Password is required"),
    WRONG_PASSWORD(38, "Wrong password"),
    INVALID_JWT_SIGNATURE(40, "Invalid JWT signature"),
    INVALID_JWT_TOKEN(41, "Invalid JWT token"),
    JWT_TOKEN_EXPIRED(42, "JWT token expired"),
    UNSUPPORTED_JWT_TOKEN(43, "Unsupported JWT token"),
    JWT_CLAIMS_EMPTY(44, "JWT claims empty"),
    NEED_AUTHENTICATION(45, "Full authentication is required to access this resource"),
    SERVER_ERROR(47, "Server error"),
    VERIFY_EMAIL_SUCCESS(48, "Verify email success"),
    VERIFY_EMAIL_EXPIRE(49, "Verify email expire"),
    VERIFY_EMAIL_REQUEST_INVALID(50, "Verify email request invalid"),
    UPDATE_EMAIL_SUCCESS(51, "Update email success"),
    OLD_AND_NEW_PASSWORD_ARE_DUPLICATED(52, "Old password and new password are duplicated"),
    UPDATE_PASSWORD_SUCCESS(53, "Update password success"),
    TWO_FA_VERIFICATION_IS_ALREADY_ENABLE(54, "2FA Verification is already enable"),
    TOTP_VALIDATION_FAILED(55, "Time based one time password is not valid"),
    TWO_FA_VERIFICATION_IS_NOT_ENABLE(56, "2FA Verification is not enable"),
    CHANGE_USERNAME_ONLY_ONCE_EVERY_24_HOURS(57, "You can change Username only once every 24 hours"),
    SEND_VERIFY_EMAIL_SUCCESS(58, "Send verify email success"),
    EMAIL_IS_VERIFIED(59, "Email is verified"),
    INVALID_VERIFY_EMAIL_TOKEN(60, "Invalid verify email token"),
    VERIFY_EMAIL_TOKEN_NOT_FOUND(61, "Verify email token not found"),
    USER_NOT_FOUND_WITH_GIVEN_USERNAME(62, "User not found with given username"),
    USER_ID_NOT_FOUND_IN_CONTEXT_HOLDER(63, "User id not found in context holder"),
    NOT_FIRST_TIME_RESET_PASSWORD(64, "Not first time reset password"),
    MERCHANT_CODE_NOT_FOUND(65, "Merchant code not found"),
    USERNAME_NOT_FOUND_IN_MERCHANT(66, "Username not found in merchant"),
    MERCHANT_CODE_REQUIRED(67, "Merchant code required"),
    INVALID_MERCHANT_CODE_LENGTH(68, "Invalid merchant code length"),
    LOGIN_FAIL(69, "Login fail"),
    ACCOUNT_LOCKED(70, "Account locked"),
    ACCOUNT_DISABLED(71, "Account disabled"),
    INVALID_REDIRECT_URL_FORMAT(72, "Invalid redirect url format"),
    INVALID_KYC_LEVEL(73, "Invalid kyc level"),
    FIST_NAME_IS_REQUIRED(74, "First name is required"),
    LAST_NAME_IS_REQUIRED(75, "Last name is required"),
    DATE_OF_BIRTH_IS_REQUIRED(76, "Date of birth is required"),
    COUNTRY_IS_REQUIRED(77, "Country is required"),
    ADDRESS_IS_REQUIRED(78, "Address is required"),
    CITY_IS_REQUIRED(79, "City is required"),
    POSTAL_CODE_IS_REQUIRED(80, "Postal code is required"),
    INVALID_LENGTH_FIELD_SUBMIT_KYC(81, "Invalid length field submit kyc"),
    IDENTITY_IMAGE_IS_REQUIRED(82, "Identity image is required"),
    ADDRESS_IMAGE_IS_REQUIRED(83, "Address image is required"),
    INVALID_FILE_TYPE(84, "Invalid file type"),
    MEMBER_KYC_NOT_FOUND(85, "Member kyc not found"),
    SUBMIT_KYC_LEVEL_1_SUCCESS(86, "Submit kyc level 1 success"),
    SAVE_FILE_KYC_ERROR(87, "Save file kyc error"),
    SUBMIT_KYC_LEVEL_2_SUCCESS(88, "Submit kyc level 2 success"),
    SUBMIT_KYC_LEVEL_3_SUCCESS(89, "Submit kyc level 3 success"),
    KYC_ALREADY_EXISTED(90, "Kyc already existed"),
    INACTIVE_DEPARTMENT(91, "User is in inactive department"),
    MEMBER_SIGN_UP_RISK_RESTRICTION(92, "Member sign up Risk Restriction"),
    MEMBER_LOGIN_IN_INACTIVE(93, "Member Inactive"),
    COUNTRY_NOT_FOUND(94, "Country not found"),
    COUNTRY_RESTRICTION(95,
            "Dear member, your country is restricted. If you have any questions or would like to appeal this decision, please contact our customer service team."),
    IP_RESTRICTION(96,
            "Dear member, your account has been restricted. If you have any questions or would like to appeal this decision, please contact our customer service team."),
    UPDATE_EMAIL_LIMIT(97, "You can change Email only 3 times every 24 hours"),
    ONLY_REQUIRED_KYC_CAN_BE_SUBMITTED(98, "Only required kyc can be submitted"),
    EMAIL_OR_PASSWORD_IS_INCORRECT(99, "Email or password is incorrect"),
    USERNAME_OR_PASSWORD_IS_INCORRECT(100, "Username or password is incorrect"),
    CONTINUE_WITH_GOOGLE_FAILED(101, "Continue with Google failed"),
    CONTINUE_WITH_TELEGRAM_FAILED(102, "Continue with Telegram failed"),
    CONTINUE_WITH_META_FAILED(103, "Continue with Metamask failed"),
    MEMBER_MAX_FAIL_LOGIN_ATTEMPT(104, "Max fail login attempt"),
    PERMISSION_DENIED(105, "Permission denied"),
    NOT_ALLOWED_FORGOT_PASSWORD(106, "Not allowed forgot password"),
    INACTIVE_ACCOUNT(107, "Your account has been inactive"),
    INVALID_LOGIN(108, "Invalid login attempt"),
    AFFILIATE_OR_REFERRAL_CODE_IS_NOT_EXIST(109, "Affiliate or referral code is not exist"),
    ACCOUNT_DELETED(110, "Account deleted"),
    ACCOUNT_SUSPENDED(111, "Account suspended"),
    INVALID_LOGIN_CREDENTIAL(112, "Invalid login credential"),
    BRAND_NOT_FOUND(113, "Brand not found"),
    ;

    private final Integer code;
    private final String message;

}