import React from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

const Editor = ({ value, onChange, error }) => {
  return (
    <div>
      <CKEditor
        editor={ClassicEditor}
        data={value} 
        onChange={(event, editor) => {
          const data = editor.getData(); 
          onChange(data); 
        }}
      />
      {error && <p className="text-red-500 mt-2">{error.message}</p>} 
    </div>
  );
};

export default Editor;

