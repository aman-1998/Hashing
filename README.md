# Hashing:

# Separate chaining (open hashing):

Separate chaining is one of the most commonly used collision resolution techniques. It is usually implemented using linked lists. In separate chaining, each element of the hash table is a linked list. To store an element in the hash table you must insert it into a specific linked list. If there is any collision (i.e. two different elements have same hash value) then store both the elements in the same linked list.

The cost of a lookup is that of scanning the entries of the selected linked list for the required key. If the distribution of the keys is sufficiently uniform, then the average cost of a lookup depends only on the average number of keys per linked list. For this reason, chained hash tables remain effective even when the number of table entries (N) is much higher than the number of slots.

For separate chaining, the worst-case scenario is when all the entries are inserted into the same linked list. The lookup procedure may have to scan all its entries, so the worst-case cost is proportional to the number (N) of entries in the table.

# Linear probing (open addressing or closed hashing):

In open addressing, instead of in linked lists, all entry records are stored in the array itself. When a new entry has to be inserted, the hash index of the hashed value is computed and then the array is examined (starting with the hashed index). If the slot at the hashed index is unoccupied, then the entry record is inserted in slot at the hashed index else it proceeds in some probe sequence until it finds an unoccupied slot.

The probe sequence is the sequence that is followed while traversing through entries. In different probe sequences, you can have different intervals between successive entry slots or probes.

When searching for an entry, the array is scanned in the same sequence until either the target element is found or an unused slot is found. This indicates that there is no such key in the table. The name "open addressing" refers to the fact that the location or address of the item is not determined by its hash value.

Linear probing is when the interval between successive probes is fixed (usually to 1). Let’s assume that the hashed index for a particular entry is index. The probing sequence for linear probing will be:

index = index % hashTableSize

index = (index + 1) % hashTableSize

index = (index + 2) % hashTableSize

index = (index + 3) % hashTableSize

and so on…


# Double hashing:

Linear probing collision resolution leads to clusters in the table, because if two keys collide, the next position probed will be the same for both of them. 
The idea of double hashing: Make the offset to the next position probed depend on the key value, so it can be different for different keys
Need to introduce a second hash function H 2 (K), which is used as the offset in the probe sequence (think of linear probing as double hashing with H 2 (K) == 1)
For a hash table of size M, H 2 (K) should have values in the range 1 through M-1; if M is prime, one common choice is H2(K) = 1 + ( (K/M) mod (M-1) )
The insert algorithm for double hashing is then:

1. Set indx = H(K); offset = H 2 (K)

2. If table location indx already contains the key, no need to insert it. Done!

3. Else if table location indx is empty, insert key there. Done!

4. Else collision. Set indx = (indx + offset) mod M.

5. If indx == H(K), table is full! (Throw an exception, or enlarge table.) Else go to 2.
With prime table size, double hashing works very well in practice
