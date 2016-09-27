<?php

namespace App\Http\Controllers\Category;

use App\Http\Controllers\Controller;
use App\Model\Category;
use App\Services\Category\CategoryService;
use App\Util\JsonUtil;
use Illuminate\Http\Request;

class CategoryController extends Controller
{

    protected $categoryService;

    /**
     * CategoryController constructor.
     * @param $categoryService
     */
    public function __construct(CategoryService $categoryService)
    {
        $this->categoryService = $categoryService;
    }


    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $categories = $this->categoryService->getAll();
        return view('category.list', ['categories' => $categories]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('category.create');
    }


    /**
     * 插入一条新分类
     *
     * @param  Request $request
     * @return mixed
     */
    public function store(Request $request)
    {
        $category = new Category;
        $category->name = $request->get('name');

        if ($this->categoryService->save($category)) {
            $categorySaved = $this->categoryService->getByName($category->name);
            exit(JsonUtil::toJson(0, $categorySaved));
        } else {
            exit(JsonUtil::toJson(3000));
        }
    }

    /**
     * Display the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $category = $this->categoryService->get($id ?: 0);
        return view('category.update', ['category' => $category]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request $request
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $this->categoryService->drop($id ?: 0);
        return redirect('/category');
    }
}
