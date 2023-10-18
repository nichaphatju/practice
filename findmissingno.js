function solution(A) {
    // Implement your solution here
    if(A.length === 0) return 1;
    if(A.length === 1){
        return A[0] === 1? 2:  1;
    }
    A.sort((a,b) => {return a-b});
    
    const missingIndex = dosearch(0, A.length-1, A);
    if((missingIndex+1) === A.length && A[A.length-1] === A.length){
        return A.length+1;
    }
    return missingIndex+1;
}

function dosearch(start, end, A){
    if(start < end){
        let mid = Math.floor(((end - start)/2)+start);
        let midExpect = mid+1;
        if(A[mid] > midExpect){
            return dosearch(start, mid, A);
        }else{
            return dosearch(mid+1, end, A);
        }
    }
    return start;
    
}