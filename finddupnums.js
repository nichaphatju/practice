function solution(A) {
    // Implement your solution here

    let num = 0;
    let dup = [];
    for(let i=0; i< A.length; i++){
        if(!dup.includes(A[i]) && A.lastIndexOf(A[i]) === i){
            num = A[i];
            break;
        }
        dup.push(A[i]);
    }
    return num;
}