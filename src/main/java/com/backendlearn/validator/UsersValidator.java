package com.backendlearn.validator;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.backendlearn.utils.ValidationConstants;

public class UsersValidator implements ValidationConstants {

	public static List<String> validateInsertingUsers(String applicationJson) {
		JsonObject convertedObject = new Gson().fromJson(applicationJson, JsonObject.class);

		List<String> validationsErrors = new ArrayList<>();
		String check;

		if (!convertedObject.has(NAME)) {
			validationsErrors.add(NAME_MISSING);
		} else {

			check = convertedObject.get(NAME).toString();

			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				validationsErrors.add(NAME_FORMAT_MISSING);

			}
		}

		if (!convertedObject.has(ABOUT)) {
			validationsErrors.add(ABOUT_MISSING);
		} else {
			check = convertedObject.get(ABOUT).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				validationsErrors.add(ABOUT_FORMAT_MISSING);
			}
		}

		if (!convertedObject.has(EMAIL)) {
			validationsErrors.add(EMAIL_MISSING);
		} else {
			check = convertedObject.get(EMAIL).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				validationsErrors.add(EMAIL_FORMAT_MISSING);
			}
		}

		if (!convertedObject.has(PASSWORD)) {

			validationsErrors.add(PASSWORD_MISSING);
		} else {
			check = convertedObject.get(PASSWORD).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				validationsErrors.add(PASSWORD_FORMAT_MISSING);
			}

		}

		return validationsErrors;

	}

	public static List<String> validateUpdateUsers(String UpdateJson) {
		List<String> errorsLists = new ArrayList<>();

		JsonObject convertedObject = new Gson().fromJson(UpdateJson, JsonObject.class);
		String check;

		if (!convertedObject.has(ID)) {
			errorsLists.add(ID_MISSING);
		}

		if (convertedObject.has(NAME)) {
			check = convertedObject.get(NAME).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				errorsLists.add(NAME_FORMAT_MISSING);
			}
		} else {
			errorsLists.add(NAME_MISSING);
		}

		if (convertedObject.has(ABOUT)) {
			check = convertedObject.get(ABOUT).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				errorsLists.add(ABOUT_FORMAT_MISSING);
			}

		} else {

			errorsLists.add(ABOUT_MISSING);
		}

		if (!convertedObject.has(EMAIL)) {
			errorsLists.add(EMAIL_MISSING);
		} else {
			check = convertedObject.get(EMAIL).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				errorsLists.add(EMAIL_FORMAT_MISSING);
			}
		}

		if (!convertedObject.has(PASSWORD)) {

			errorsLists.add(PASSWORD_MISSING);
		} else {
			check = convertedObject.get(PASSWORD).toString();
			if (check.isEmpty() || check.isBlank() || check.equals("\"\"")) {
				errorsLists.add(PASSWORD_FORMAT_MISSING);
			}

		}

		return errorsLists;

	}
}
