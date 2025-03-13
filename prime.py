import time
# Function to check if a number is prime
def is_prime(n):
    if n < 2:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

# Function to find prime numbers in a range
def find_primes(start, end):
    primes = []
    for num in range(start, end):
        if is_prime(num):
            primes.append(num)
    return primes

# Measure execution time
start_time = time.time()
primes_list = find_primes(1, 50000)
end_time = time.time()

print(f"Primes Found: {len(primes_list)}")
print(f"Execution Time: {end_time - start_time} seconds")
