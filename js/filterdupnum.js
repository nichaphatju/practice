function solution(A) {
    // Implement your solution here
    A = A.filter((a, index) => {
        return A.indexOf(a) === index;
    });
    return A.length;
}