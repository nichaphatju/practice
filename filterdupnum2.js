function solution(A) {
    // Implement your solution here
    let unique = [];
    for(let i=0; i< A.length; i++){
        if(A.lastIndexOf(A[i]) === i){
            unique.push(A[i]);
        }
    }
    return unique.length;
}