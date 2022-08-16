import React, { useState } from 'react'
import {BsHandThumbsUp, BsHandThumbsUpFill} from 'react-icons/bs';
import { rateme } from '../service/rating.service';



const Movie = ({item}) => {
  var usernameStore = sessionStorage.getItem("username");
  const [like, setLike] = useState(false);
  const saveShow = (e, title, status) => {
    const value ={title, status}
    rateme(value)
    alert(usernameStore + " Rated as "+ status + " For this "+ title + " Movie")
   
  }

  return (
    <div className='w-[160px] sm:w-[200px] md:w-[240px] lg:w-[280px] inline-block cursor-pointer relative p-2'>
        <img className='w-full h-auto block' src={`https://image.tmdb.org/t/p/w500/${item?.imgurl}`} alt={item?.title}/>
        <div className='absolute top-0 left-0 w-full h-full hover:bg-black/80 opacity-0 hover:opacity-100 text-white'>
            <p className='white-space-normal text-xs md:text-sm font-bold flex justify-center items-center h-full text-center'>{item?.title}</p>
            
            {/* onClick={saveShow(item?.title, 'like')} */}
            <p onClick={(event) => saveShow(event, item?.title,'Like')}>{like ? <BsHandThumbsUpFill className='absolute top-4 left-4 text-green-300' /> : <BsHandThumbsUp className='absolute top-4 left-4 text-green-300'/>}</p>
        </div>
    </div>
  )
}

export default Movie