function solution(A) {
    // Implement your solution here
    A.sort((a,b) => {
        return a-b;
    });
    for(let i=0; i< A.length; i++){
        if(A[i] !== i+1)
        return 0;
    }
    return 1;
}