package tcpServer;

public class StringUtil {
	 /**
     * Check whether the passed-in string is null or empty.
     *
     * @param aInStringToCheck string to check
     * @return true if the string is null or empty; otherwise false.
     */
    public static boolean isNullOrEmpty(String aInStringToCheck)
    {
        return (aInStringToCheck == null || aInStringToCheck.trim().isEmpty());
    }

    /**
     * Check whether the passed-in string is NOT empty.
     *
     * @param aInStringToCheck string to check
     * @return true if the string is NOT empty; otherwise false.
     */
    public static boolean isNotEmpty(String aInStringToCheck)
    {
        return !isNullOrEmpty(aInStringToCheck);
    }

    /**
     * Check whether the passed-in string is empty.
     *
     * @param aInStringToCheck string to check
     * @return true if the string is empty; otherwise false.
     */
    public static boolean isEmpty(String aInStringToCheck)
    {
        return (aInStringToCheck != null && aInStringToCheck.trim().isEmpty());
    }

    /**
     * Check whether the passed-in string is "true" or "false" case
     * insensitive.
     *
     * @param aInStringToCheck string to check
     * @return true if the string is neither "true" not "false case insensitive;
     * otherwise false.
     */
    public static boolean isTrueOrFalse(String aInStringToCheck)
    {
        return aInStringToCheck == null ||
                (!aInStringToCheck.trim().toLowerCase().equals("true") &&
                        !aInStringToCheck.trim().toLowerCase().equals("false"));
    }

    /**
     * Method to check if passed strings are equal or not.
     *
     * @param aInString1 the first reference string
     * @param aInString2 the second  reference strings  which is to be
     *                   compared.
     * @return {@code true} if first string is the same as the second argument
     * string; {@code false} otherwise.
     */
    public static boolean isEqual(String aInString1, String aInString2)
    {

        if (aInString1 == null && aInString2 == null)
        {
            return true;
        }
        else
        {
            if (aInString1 != null && aInString2 == null)
            {
                return false;

            }
            else if (aInString1 == null && aInString2 != null)
            {
                return false;

            }
            else
            {
                return aInString1.equals(aInString2);
            }
        }


    }
}
