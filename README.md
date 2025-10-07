# CSC 207: Text Editor

**Author**: _(TODO: fill me in)_

## Resources Used

+ _(TODO: fill me in)_
+ ...
+ ...

## Changelog
1. The revelant input is the length of the string
2. The critical operations concatonation of the substring from 0 to the index being inserted at, the new character, and the sunstring from the character after the inserted one to the end of the string s.
3. T(n) = 2n + 2
4. O(n) = n

T(n) = n + 1 since the insert method must gets the substrings from str to the index being inserted at and the index after the one being inserted at to the end of the string. the character being inserted is then added to the first substring, but since Strings are immutable, all the characters must be copied from the substring to a new array with ch at the end. Then, this string must be added to the other substring, which similarly, must individually copy each character in both strings to a new String. The time to both substrings is n, since the string is of length n, and the time to copy both the substrings to new strings is also n, so in total we have a time complexity for these operations of 2n. Since the character being inserted must be copied to new strings twice, we have a time complexity of 2 for these operations. In total, we have a time complexity of 2n + 2.


_(TODO: fill me in with a log of your committed changes)_
